package com.ipi.springfoot.services.impl;

import com.ipi.springfoot.dao.EquipeDao;
import com.ipi.springfoot.dao.MatchDao;
import com.ipi.springfoot.pojos.Equipe;
import com.ipi.springfoot.pojos.Match;
import com.ipi.springfoot.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeDao equipeDao;

    @Autowired
    private MatchDao matchDao;

    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeDao.save(equipe);
    }

    @Override
    public Equipe recupererEquipe(Long idEquipe) {
        return equipeDao.findById(idEquipe).orElse(null);
    }

    @Override
    public List<Equipe> recupererEquipeAll() {
        return equipeDao.findAll();
    }

    /*@Override
    public List<Match> recupererMatchAll(Equipe equipe) {
        return matchDao.findByEquipe(equipe);
    }*/
}
