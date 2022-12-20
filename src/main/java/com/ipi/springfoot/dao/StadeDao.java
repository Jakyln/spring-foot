package com.ipi.springfoot.dao;

import com.ipi.springfoot.pojos.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadeDao extends JpaRepository<Stade, Long> {
}
