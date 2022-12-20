package com.ipi.springfoot.services.impl;

import com.ipi.springfoot.dao.MatchDao;
import com.ipi.springfoot.pojos.Match;
import com.ipi.springfoot.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchDao matchDao;

    @Override
    public Match ajouterMatch(Match match) {
        return matchDao.save(match);
    }

    @Override
    public Match recupererMatch(Long idMatch) {
        return matchDao.findById(idMatch).orElse(null);
    }

    @Override
    public List<Match> recupererMatchAll() {
        return matchDao.findAll();
    }
}
