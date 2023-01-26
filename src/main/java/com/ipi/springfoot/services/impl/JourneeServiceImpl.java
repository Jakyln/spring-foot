package com.ipi.springfoot.services.impl;

import com.ipi.springfoot.dao.JourneeDao;
import com.ipi.springfoot.dao.MatchDao;
import com.ipi.springfoot.pojos.Journee;
import com.ipi.springfoot.pojos.Match;
import com.ipi.springfoot.services.JourneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JourneeServiceImpl implements JourneeService {

    @Autowired
    private JourneeDao journeeDao;

    @Autowired
    private MatchDao matchDao;

    @Override
    public Journee ajouterJournee(Journee journee) {
        return journeeDao.save(journee);
    }

    @Override
    public Journee recupererJournee(Long idJournee) {
        return journeeDao.findById(idJournee).orElse(null);
    }

    @Override
    public List<Journee> recupererJourneeAll() {
        return journeeDao.findAll();
    }

    @Override
    public List<Match> recupererMatchAll(Journee journee) {
        return matchDao.findByJournee(journee);
    }
}
