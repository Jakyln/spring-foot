package com.ipi.springfoot.services;

import com.ipi.springfoot.pojos.Championat;
import com.ipi.springfoot.pojos.Pays;

import java.util.List;

public interface PaysService {
    Pays ajouterPays(Pays pays);
    Pays recupererPays(Long idPays);
    List<Pays> recupererPaysAll();
    List<Championat> recupererChampionatAll(Pays pays);
}
