package com.ipi.springfoot.services;

import com.ipi.springfoot.pojos.Equipe;
import com.ipi.springfoot.pojos.Match;

import java.util.List;

public interface EquipeService {
    Equipe ajouterEquipe(Equipe equipe);
    Equipe recupererEquipe(Long idEquipe);
    List<Equipe> recupererEquipeAll();
    //List<Match> recupererMatchAll(Equipe equipe);
}
