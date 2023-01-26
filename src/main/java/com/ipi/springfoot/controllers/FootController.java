package com.ipi.springfoot.controllers;

import com.ipi.springfoot.pojos.*;
import com.ipi.springfoot.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/")
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

    @GetMapping({"/", "details_equipe"})
    public String details_equipe(Model model, @RequestParam long idEquipe) {
        Equipe equipe = equipeService.recupererEquipe(idEquipe);
        model.addAttribute("equipe", equipe);

        return "details";
    }

    @GetMapping({"/", "details_championat"})
    public String details_championat(Model model, @RequestParam long idChampionat) {
        Championat championat = championatService.recupererChampionat(idChampionat);
        List<Equipe> equipes = championat.getEquipes();

        model.addAttribute("championat", championat);

        return "details";
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

            Journee journee1 = new Journee(1,championat1);
            journeeService.ajouterJournee(journee1);

            // Récupère les équipe avec leurs id généré lors de leurs insertions
            equipe1 = equipeService.recupererEquipeAll().get(0);
            equipe2 = equipeService.recupererEquipeAll().get(1);
            Match match1 = new Match(2,0,stade1, equipe1.getId(), equipe2.getId(), journee1);
            matchService.ajouterMatch(match1);


            System.out.println("Donnees ajoutees");
        }
        System.out.println("DB construite");
    }

}
