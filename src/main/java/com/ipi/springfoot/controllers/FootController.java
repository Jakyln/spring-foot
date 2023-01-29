package com.ipi.springfoot.controllers;

import com.ipi.springfoot.pojos.*;
import com.ipi.springfoot.services.*;
import jakarta.annotation.PostConstruct;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class FootController {

    @Autowired
    private UserService userService;
    @Autowired
    private PaysService paysService;
    @Autowired
    private ChampionatService championatService;
    @Autowired
    private EquipeService equipeService;
    @Autowired
    private JourneeService journeeService;
    @Autowired
    private StadeService stadeService;
    @Autowired
    private MatchService matchService;

    public FootController() {
    }

    public FootController(
            UserService userService,
            PaysService paysService,
            ChampionatService championatService,
            EquipeService equipeService,
            JourneeService journeeService,
            StadeService stadeService,
            MatchService matchService) {
        super();
        this.userService = userService;
        this.paysService = paysService;
        this.championatService = championatService;
        this.equipeService = equipeService;
        this.journeeService = journeeService;
        this.stadeService = stadeService;
        this.matchService = matchService;
    }

    @GetMapping({ "equipe/{idEquipe}/detail"})
    public String details_equipe(Model model, @PathVariable long idEquipe) {
        Equipe equipe = equipeService.recupererEquipe(idEquipe);
        List<Stade> stades = stadeService.recupererStadeAll();
        model.addAttribute("allStades", stades);

        model.addAttribute("equipe", equipe);

        return "details";
    }

    @GetMapping({ "equipe/newEquipe"})
    public String newEquipe(Model model, @ModelAttribute Equipe equipe) {
        List<Stade> stades = stadeService.recupererStadeAll();
        model.addAttribute("allStades", stades);
        model.addAttribute("equipe", equipe);
        return "details";
    }


    @PostMapping(value = "equipe/saveEquipe")
    public RedirectView saveEquipe(Model model, @Validated @ModelAttribute Equipe equipe, @RequestParam long stadeId){
        Stade stade = stadeService.recupererStade(stadeId);
        equipe.setStade(stade);
        equipe = equipeService.ajouterEquipe(equipe);
        model.addAttribute("equipe", equipe);
        return new RedirectView("" + equipe.getId() +"/detail");
    }

    
    @GetMapping({"/", "details_championat"})
    public String details_championat(Model model, @RequestParam long idChampionat) {
        Championat championat = championatService.recupererChampionat(idChampionat);
        List<Equipe> equipes = championat.getEquipes();
        List<Journee> journees = championat.getJournees();
        journees.sort(Comparator.comparing(Journee::getNumero).reversed());
        List<Match> matches = new ArrayList<>();
        List<EquipeChampionatStats> equipeChampionatStats = new ArrayList<>();
        for (Journee journee: journees) {
            for (Match match: journee.getMatches()) {
                matches.add(match);
            }
        }
        for (Equipe equipe: equipes) {
            Integer totalPoint = 0;
            Integer matchGagnee = 0;
            Integer matchPerdu = 0;
            Integer matchNul = 0;
            Integer maxJournee = 0;
            for (Match match: matches) {
                if (equipe == match.getEquipe1()){
                    totalPoint += match.getPointEquipe1();
                    if (match.getPointEquipe1() > match.getPointEquipe2()){
                        matchGagnee ++;
                    }
                    if (match.getPointEquipe1() < match.getPointEquipe2()){
                        matchPerdu ++;
                    }
                    if (match.getPointEquipe1() == match.getPointEquipe2()){
                        matchNul ++;
                    }
                    if (maxJournee < match.getJournee().getNumero()){
                        maxJournee = match.getJournee().getNumero();
                    }
                }
                if (equipe == match.getEquipe2()) {
                    totalPoint += match.getPointEquipe2();
                    if (match.getPointEquipe1() > match.getPointEquipe2()) {
                        matchPerdu++;
                    }
                    if (match.getPointEquipe1() < match.getPointEquipe2()) {
                        matchGagnee++;
                    }
                    if (match.getPointEquipe1() == match.getPointEquipe2()) {
                        matchNul++;
                    }
                    if (maxJournee < match.getJournee().getNumero()){
                        maxJournee = match.getJournee().getNumero();
                    }
                }
            }
            EquipeChampionatStats equipeStats = new EquipeChampionatStats(equipe, totalPoint, matchGagnee, matchPerdu, matchNul, maxJournee);
            equipeChampionatStats.add(equipeStats);
        }
        equipeChampionatStats.sort(Comparator.comparing(EquipeChampionatStats::getTotalPoint).reversed());

        model.addAttribute("championat", championat);
        model.addAttribute("equipeChampionatStats", equipeChampionatStats);
        return "indexClassement";
    }

    @GetMapping({"/championnat/{id}/resultatsListe"})
    public String listResultatsOfChampionnat(Model model, @PathVariable long id){
        Equipe equipe = equipeService.recupererEquipe(id);
        Championat championat = championatService.recupererChampionat(id);
        HashMap<String,List<Match>> allMatchOfChampionnat = new HashMap<>();

        List<Journee> journees = championat.getJournees();
        for (Journee journee : journees) {
            List<Match> allMatchOfJournee = journee.getMatches();

            allMatchOfChampionnat.put(journee.getNumero().toString(),allMatchOfJournee);
        }
        model.addAttribute("championat",championat);
        model.addAttribute("allMatchForAllJournees",allMatchOfChampionnat);

        return "liste";
    }

    @GetMapping({ "championnats"})
    public String championnats(Model model) {
        List<Championat> championats = championatService.recupererChampionatAll();
        model.addAttribute("championats", championats);
        return "indexListeRes";
    }

    @GetMapping({ "championnat/newChampionnat"})
    public String newChampionnat(Model model, @ModelAttribute Championat championat) {
        List<Pays> pays = paysService.recupererPaysAll();
        model.addAttribute("allPays", pays);
        model.addAttribute("championat", championat);
        return "championnatForm";
    }

    @PostMapping(value = "championnat/saveChampionnat")
    public RedirectView saveChampionnat(Model model, @Validated @ModelAttribute Championat championat, @RequestParam long paysId){
        Pays pays = paysService.recupererPays(paysId);
        championat.setPays(pays);
        championat = championatService.ajouterChampionat(championat);
        model.addAttribute("championat", championat);
        return new RedirectView("/championnats");
    }

    @PostConstruct
    private void init() {
        if (userService.recupererUserAll().isEmpty()) {
            User user1 = new User();
            user1.setNom("Delond");
            user1.setPrenom("Allin");
            user1.setLogin("allin.delond");
            user1.setMdp("123456");
            user1.setPseudo("AllinD");
            user1.setEmail("allin.delong@gmail.com");
            userService.ajouterUser(user1);
            User user2 = new User();
            user2.setNom("Delond");
            user2.setPrenom("Allin");
            user2.setLogin("allin.delond");
            user2.setMdp("123456");
            user2.setPseudo("AllinD");
            user2.setEmail("allin.delong@gmail.com");
            userService.ajouterUser(user2);

            Pays pays1 = new Pays();
            pays1.setNom("France");
            pays1.setLogo("logo_france.png");
            paysService.ajouterPays(pays1);
            Pays pays2 = new Pays();
            pays2.setNom("Allemagne");
            pays2.setLogo("logo_allemagne.png");
            paysService.ajouterPays(pays2);
            Pays pays3 = new Pays();
            pays3.setNom("Espagne");
            pays3.setLogo("logo_espagne.png");
            paysService.ajouterPays(pays3);
            Pays pays4 = new Pays();
            pays4.setNom("Italie");
            pays4.setLogo("logo_italie.png");
            paysService.ajouterPays(pays4);

            Championat championat1 = new Championat(
                    "Coupe du monde",
                    "logo_coupe_du_monde.png",
                    Date.valueOf("2022-11-23"),
                    Date.valueOf("2022-11-30"),
                    1,
                    1,
                    0,
                    "pool",
                    pays1
            );
            championatService.ajouterChampionat(championat1);

            Stade stade1 = new Stade("Groupama Stadium", "5 rue perdu", 1500, "0411223344");
            Stade stade2 = new Stade("Italia Stadium", "10 rue d'italie", 1200, "0888888888");
            stadeService.ajouterStade(stade1);
            stadeService.ajouterStade(stade2);

            Equipe equipe1 = new Equipe(
                    "OL",
                    Date.valueOf("2000-1-1"),
                    "logo_ol.png",
                    "Laurent Blanc",
                    "Jean-Michel Aulas",
                    "actif",
                    "ici",
                    "0612345678",
                    "www.OL.fr",
                    stade1
            );
            equipeService.ajouterEquipe(equipe1);

            Equipe equipe2 = new Equipe(
                    "italie_equipe",
                    Date.valueOf("2000-1-1"),
                    "logo_italie_equipe.png",
                    "italie_entraineur",
                    "italie_president",
                    "actif",
                    "la-bas",
                    "0687654321",
                    "www.italie_equipe.it",
                    stade2
            );
            equipeService.ajouterEquipe(equipe2);
            List<Equipe> equipeChampionat = new ArrayList<>();
            equipeChampionat.add(equipe1);
            equipeChampionat.add(equipe2);
            championat1.setEquipes(equipeChampionat);

            Journee journee1 = new Journee(1,championat1);
            journeeService.ajouterJournee(journee1);

            // Récupère les équipe avec leurs id généré lors de leurs insertions
            equipe1 = equipeService.recupererEquipeAll().get(0);
            equipe2 = equipeService.recupererEquipeAll().get(1);
            Match match1 = new Match(2,0,stade1, equipe1.getId(), equipe2.getId(), journee1, equipe1, equipe2);
            matchService.ajouterMatch(match1);


            System.out.println("Donnees ajoutees");
        }
        System.out.println("DB construite");
    }

/*    @GetMapping({"/", "index"})
    public String detailEquipe(Model model, @RequestParam long id){

        return "hello"; // ou page details
    }*/

/*    @GetMapping({"/equipes/{id}/detail"})
    public String detailEquipe(Model model, @PathVariable long id){
        Equipe equipe = equipeService.recupererEquipe(id);
        model.addAttribute("equipe",equipe);
        return "details"; // ou page details
    }*/



}
