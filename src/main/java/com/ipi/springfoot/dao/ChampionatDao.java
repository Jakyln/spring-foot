package com.ipi.springfoot.dao;

import com.ipi.springfoot.pojos.Championat;
import com.ipi.springfoot.pojos.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionatDao extends JpaRepository<Championat, Long> {
    List<Championat> findByPays(Pays pays);
}
