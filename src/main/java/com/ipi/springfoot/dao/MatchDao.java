package com.ipi.springfoot.dao;

import com.ipi.springfoot.pojos.Equipe;
import com.ipi.springfoot.pojos.Journee;
import com.ipi.springfoot.pojos.Match;
import com.ipi.springfoot.pojos.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchDao extends JpaRepository<Match, Long> {
    //List<Match> findByEquipe(Equipe equipe);

    List<Match> findByJournee(Journee journee);

    List<Match> findByStade(Stade stade);
}
