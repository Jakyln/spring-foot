package com.ipi.springfoot.services.impl;

import com.ipi.springfoot.dao.ChampionatDao;
import com.ipi.springfoot.dao.JourneeDao;
import com.ipi.springfoot.pojos.Championat;
import com.ipi.springfoot.pojos.Journee;
import com.ipi.springfoot.services.ChampionatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionatServiceImpl implements ChampionatService {

    @Autowired
    private ChampionatDao championatDao;

    @Autowired
    private JourneeDao journeeDao;

    @Override
    public Championat ajouterChampionat(Championat championat) {
        return championatDao.save(championat);
    }

    @Override
    public Championat recupererChampionat(Long idChampionat) {
        return championatDao.findById(idChampionat).orElse(null);
    }

    @Override
    public List<Championat> recupererChampionatAll() {
        return championatDao.findAll();
    }

    @Override
    public List<Journee> recupererJourneeAll(Championat championat) {
        return journeeDao.findByChampionat(championat);
    }
}
