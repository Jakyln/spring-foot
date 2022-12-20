package com.ipi.springfoot.services;

import com.ipi.springfoot.pojos.Journee;
import com.ipi.springfoot.pojos.Match;

import java.util.List;

public interface JourneeService {
    Journee ajouterJournee(Journee journee);
    Journee recupererJournee(Long idJournee);
    List<Journee> recupererJourneeAll();
    List<Match> recupererMatchAll(Journee journee);
}
