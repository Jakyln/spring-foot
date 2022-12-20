package com.ipi.springfoot.services;

import com.ipi.springfoot.pojos.Championat;
import com.ipi.springfoot.pojos.Journee;

import java.util.List;

public interface ChampionatService {
    Championat ajouterChampionat(Championat championat);
    Championat recupererChampionat(Long idChampionat);
    List<Championat> recupererChampionatAll();
    List<Journee> recupererJourneeAll(Championat championat);
}
