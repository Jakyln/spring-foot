package com.ipi.springfoot.services;

import com.ipi.springfoot.pojos.Match;

import java.util.List;

public interface MatchService {
    Match ajouterMatch(Match match);
    Match recupererMatch(Long idMatch);
    List<Match> recupererMatchAll();
}
