package com.ipi.springfoot.controllers;

import com.ipi.springfoot.pojos.Equipe;
import com.ipi.springfoot.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
        Equipe equipe1 = new Equipe(Date)
    }

}
