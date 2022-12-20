package com.ipi.springfoot.services.impl;

import com.ipi.springfoot.dao.EquipeDao;
import com.ipi.springfoot.dao.MatchDao;
import com.ipi.springfoot.dao.StadeDao;
import com.ipi.springfoot.pojos.Equipe;
import com.ipi.springfoot.pojos.Match;
import com.ipi.springfoot.pojos.Stade;
import com.ipi.springfoot.services.StadeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StadeServiceImpl implements StadeService {

    @Autowired
    private StadeDao stadeDao;

    @Autowired
    private EquipeDao equipeDao;

    @Autowired
    private MatchDao matchDao;

    @Override
    public Stade ajouterStade(Stade stade) {
        return stadeDao.save(stade);
    }

    @Override
    public Stade recupererStade(Long idStade) {
        return stadeDao.findById(idStade).orElse(null);
    }

    @Override
    public List<Stade> recupererSatdeAll() {
        return stadeDao.findAll();
    }

    @Override
    public List<Equipe> recupererEquipeAll(Stade stade) {
        return equipeDao.findByStade(stade);
    }

    @Override
    public List<Match> recupererMatchAll(Stade stade) {
        return matchDao.findByStade(stade);
    }
}
