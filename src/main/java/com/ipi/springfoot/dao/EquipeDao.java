package com.ipi.springfoot.dao;

import com.ipi.springfoot.pojos.Equipe;
import com.ipi.springfoot.pojos.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeDao extends JpaRepository<Equipe, Long> {
    List<Equipe> findByStade(Stade stade);
}
