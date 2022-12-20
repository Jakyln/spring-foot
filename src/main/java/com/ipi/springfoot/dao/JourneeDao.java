package com.ipi.springfoot.dao;

import com.ipi.springfoot.pojos.Championat;
import com.ipi.springfoot.pojos.Journee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JourneeDao extends JpaRepository<Journee, Long> {
    List<Journee> findByChampionat(Championat championat);
}
