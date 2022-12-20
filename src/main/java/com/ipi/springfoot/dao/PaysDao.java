package com.ipi.springfoot.dao;

import com.ipi.springfoot.pojos.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysDao extends JpaRepository<Pays, Long> {
}
