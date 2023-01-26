package com.ipi.springfoot.services;

import com.ipi.springfoot.pojos.Equipe;
import com.ipi.springfoot.pojos.Match;
import com.ipi.springfoot.pojos.Stade;

import java.util.List;

public interface StadeService {
    Stade ajouterStade(Stade stade);
    Stade recupererStade(Long idStade);
    List<Stade> recupererSatdeAll();
    List<Equipe> recupererEquipeAll(Stade stade);
    List<Match> recupererMatchAll(Stade stade);
}
