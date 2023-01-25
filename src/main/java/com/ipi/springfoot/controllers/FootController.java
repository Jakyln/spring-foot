package com.ipi.springfoot.controllers;

import com.ipi.springfoot.pojos.*;
import com.ipi.springfoot.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @PostConstruct
    private void init() {
        System.out.println("DB construite");
/*        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.now();
        String text = date.format(formatter);
        String text2 = formatter.format(date);

        LocalDate parsedDate = LocalDate.parse(text2,formatter);*/

        Stade stade = new Stade("Stade du test","Allée du Boulevard",1550,"0454845247");
        Equipe equipe1 = new Equipe("Lyon",LocalDate.now(),1L,"icon_club_Lyon.png","Georges","Pierre","test","test","0454878595","test.com");
        Equipe equipe2 = new Equipe("test1",LocalDate.now(),1L,"icon_club_Lyon.png","Luke","Charlotte","test","test","0454878595","test.com");
        Equipe equipe3 = new Equipe("test2",LocalDate.now(),1L,"icon_club_Lyon.png","Fred","Pierre","test","test","0454878595","test.com");
        Equipe equipe4 = new Equipe("test3",LocalDate.now(),1L,"icon_club_Lyon.png","Michel","Fred","test","test","0454878595","test.com");
        Equipe equipe5 = new Equipe("test4",LocalDate.now(),1L,"icon_club_Lyon.png","Georges","Michel","test","test","0454878595","test.com");
        Equipe equipe6 = new Equipe("test5",LocalDate.now(),1L,"icon_club_Lyon.png","Luke","Pierre","test","test","0454878595","test.com");

        Championat championat = new Championat("test1","test",LocalDate.now(),LocalDate.now(),10,41,3,"test");
        Championat championat2 = new Championat("test2","test",LocalDate.now(),LocalDate.now(),3,5,1,"test");
        Championat championat3 = new Championat("test3","test",LocalDate.now(),LocalDate.now(),25,12,5,"test");
        Championat championat4 = new Championat("test4","test",LocalDate.now(),LocalDate.now(),5,6,1,"test");


        List<Championat> championats = championatService.recupererChampionatAll();

        Pays pays = new Pays("France","test",championats);
        Journee journee = new Journee(1,1L);
        Match match = new Match(1,2,1L,2L,1L,1L);
        User user = new User("MONS","George","George12","George123","GeorgeM","GeorgeMons@gmail.com");
        User user2 = new User("TROC","Fred","Fred12","Fred123","FredM","Fred@gmail.com");
        User user3 = new User("LEMAIRE","Pierre","Pierre12","Pierre123","PierreM","Pierre@gmail.com");
        User user4 = new User("PIBOULEAU","Michel","Michel12","Michel123","MichelM","Michel@gmail.com");
        User user5 = new User("FOURNIER","Luke","Luke12","Luke123","LukeM","Luke@gmail.com");
        User user6 = new User("DOUVRE","Charlotte","Charlotte12","Charlotte123","CharlotteM","Charlotte@gmail.com");

/*        equipeService.ajouterEquipe(equipe1);
        userService.ajouterUser(user);
        userService.ajouterUser(user2);
        userService.ajouterUser(user3);
        userService.ajouterUser(user4);
        userService.ajouterUser(user5);
        userService.ajouterUser(user6);*/



    }

}
