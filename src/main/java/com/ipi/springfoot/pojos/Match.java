package com.ipi.springfoot.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "Match_table")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer pointEquipe1;
    private Integer pointEquipe2;
    private Long idEquipe1;
    private Long idEquipe2;

    @ManyToOne
    private Stade stade;

    @ManyToOne
    private Journee journee;

    @ManyToOne
    private Equipe equipe1;

    @ManyToOne
    private Equipe equipe2;

    public Match() {
    }

    public Match(Integer pointEquipe1, Integer pointEquipe2, Stade stade, Long idEquipe1, Long idEquipe2, Journee journee, Equipe equipe1, Equipe equipe2) {
        this.pointEquipe1 = pointEquipe1;
        this.pointEquipe2 = pointEquipe2;
        this.stade = stade;
        this.idEquipe1 = idEquipe1;
        this.idEquipe2 = idEquipe2;
        this.journee = journee;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPointEquipe1() {
        return pointEquipe1;
    }

    public void setPointEquipe1(Integer pointEquipe1) {
        this.pointEquipe1 = pointEquipe1;
    }

    public Integer getPointEquipe2() {
        return pointEquipe2;
    }

    public void setPointEquipe2(Integer pointEquipe2) {
        this.pointEquipe2 = pointEquipe2;
    }

    public Long getIdEquipe1() {
        return idEquipe1;
    }

    public void setIdEquipe1(Long idEquipe1) {
        this.idEquipe1 = idEquipe1;
    }

    public Long getIdEquipe2() {
        return idEquipe2;
    }

    public void setIdEquipe2(Long idEquipe2) {
        this.idEquipe2 = idEquipe2;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public Journee getJournee() {
        return journee;
    }

    public void setJournee(Journee journee) {
        this.journee = journee;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Match{");
        sb.append("id=").append(id);
        sb.append(", pointEquipe1=").append(pointEquipe1);
        sb.append(", pointEquipe2=").append(pointEquipe2);
        sb.append(", idEquipe1=").append(idEquipe1);
        sb.append(", idEquipe2=").append(idEquipe2);
        sb.append(", stade=").append(stade);
        sb.append(", equipe1=").append(equipe1);
        sb.append(", equipe2=").append(equipe2);
        sb.append(", journee=").append(journee);
        sb.append('}');
        return sb.toString();
    }
}
