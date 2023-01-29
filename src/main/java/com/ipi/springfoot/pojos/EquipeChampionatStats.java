package com.ipi.springfoot.pojos;

public class EquipeChampionatStats {
    private Equipe equipe;
    private Integer totalPoint;
    private Integer matchGagnee;
    private Integer matchPerdu;
    private Integer matchNul;
    private Integer maxJournee;

    public EquipeChampionatStats(Equipe equipe, Integer total_point, Integer match_gagnee, Integer match_perdu, Integer match_nul, Integer max_journee) {
        this.equipe = equipe;
        this.totalPoint = total_point;
        this.matchGagnee = match_gagnee;
        this.matchPerdu = match_perdu;
        this.matchNul = match_nul;
        this.maxJournee = max_journee;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Integer getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }

    public Integer getMatchGagnee() {
        return matchGagnee;
    }

    public void setMatchGagnee(Integer matchGagnee) {
        this.matchGagnee = matchGagnee;
    }

    public Integer getMatchPerdu() {
        return matchPerdu;
    }

    public void setMatchPerdu(Integer matchPerdu) {
        this.matchPerdu = matchPerdu;
    }

    public Integer getMatchNul() {
        return matchNul;
    }

    public void setMatchNul(Integer matchNul) {
        this.matchNul = matchNul;
    }

    public Integer getMaxJournee() {
        return maxJournee;
    }

    public void setMaxJournee(Integer maxJournee) {
        this.maxJournee = maxJournee;
    }
}
