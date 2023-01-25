package com.ipi.springfoot.pojos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private LocalDate dateCreation;
    private Long idStade;
    private String logo;
    private String nomEntraineur;
    private String president;
    private String status;
    private String siege;
    private String telephone;
    private String siteWeb;

    @ManyToMany(mappedBy = "equipes")
    private List<Championat> championats;

    @ManyToOne
    private Stade stade;

    /*@OneToMany(mappedBy = "equipe1")
    private List<Match> matchesEquipe1;

    @OneToMany(mappedBy = "equipe2")
    private List<Match> matchesEquipe2;*/

    public Equipe() {
    }

    public Equipe(String nom, LocalDate dateCreation, Long idStade, String logo, String nomEntraineur, String president, String status, String siege, String telephone, String siteWeb) {
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.idStade = idStade;
        this.logo = logo;
        this.nomEntraineur = nomEntraineur;
        this.president = president;
        this.status = status;
        this.siege = siege;
        this.telephone = telephone;
        this.siteWeb = siteWeb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Long getIdStade() {
        return idStade;
    }

    public void setIdStade(Long idStade) {
        this.idStade = idStade;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNomEntraineur() {
        return nomEntraineur;
    }

    public void setNomEntraineur(String nomEntraineur) {
        this.nomEntraineur = nomEntraineur;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public List<Championat> getChampionats() {
        return championats;
    }

    public void setChampionats(List<Championat> championats) {
        this.championats = championats;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    /*public List<Match> getMatchesEquipe1() {
        return matchesEquipe1;
    }

    public void setMatchesEquipe1(List<Match> matchesEquipe1) {
        this.matchesEquipe1 = matchesEquipe1;
    }

    public List<Match> getMatchesEquipe2() {
        return matchesEquipe2;
    }

    public void setMatchesEquipe2(List<Match> matchesEquipe2) {
        this.matchesEquipe2 = matchesEquipe2;
    }*/

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipe{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", dateCreation=").append(dateCreation);
        sb.append(", idStade=").append(idStade);
        sb.append(", logo='").append(logo).append('\'');
        sb.append(", nomEntraineur='").append(nomEntraineur).append('\'');
        sb.append(", president='").append(president).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", siege='").append(siege).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", siteWeb='").append(siteWeb).append('\'');
        sb.append(", championats=").append(championats);
        sb.append(", stade=").append(stade);
        /*sb.append(", matchesEquipe1=").append(matchesEquipe1);
        sb.append(", matchesEquipe2=").append(matchesEquipe2);*/
        sb.append('}');
        return sb.toString();
    }
}
