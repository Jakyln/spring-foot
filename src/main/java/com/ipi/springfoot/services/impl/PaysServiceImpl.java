package com.ipi.springfoot.services.impl;

import com.ipi.springfoot.dao.ChampionatDao;
import com.ipi.springfoot.dao.PaysDao;
import com.ipi.springfoot.pojos.Championat;
import com.ipi.springfoot.pojos.Pays;
import com.ipi.springfoot.services.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaysServiceImpl implements PaysService {

    @Autowired
    private PaysDao paysDao;

    @Autowired
    private ChampionatDao championatDao;

    @Override
    public Pays ajouterPays(Pays pays) {
        return paysDao.save(pays);
    }

    @Override
    public Pays recupererPays(Long idPays) {
        return paysDao.findById(idPays).orElse(null);
    }

    @Override
    public List<Pays> recupererPaysAll() {
        return paysDao.findAll();
    }

    @Override
    public List<Championat> recupererChampionatAll(Pays pays) {
        return championatDao.findByPays(pays);
    }
}
