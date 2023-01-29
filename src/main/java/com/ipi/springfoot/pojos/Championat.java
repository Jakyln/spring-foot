package com.ipi.springfoot.pojos;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Championat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String logo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;
    private Integer pointGagne;
    private Integer pointPerdu;
    private Integer pointNul;
    private String typeClassement;

    @ManyToOne
    private Pays pays;

    @ManyToMany
    private List<Equipe> equipes;

    @OneToMany(mappedBy = "championat")
    private List<Journee> journees;

    public Championat() {
    }

    public Championat(String nom, String logo, Date dateDebut, Date dateFin, Integer pointGagne, Integer pointPerdu, Integer pointNul, String typeClassement, Pays pays) {
        this.nom = nom;
        this.logo = logo;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.pointGagne = pointGagne;
        this.pointPerdu = pointPerdu;
        this.pointNul = pointNul;
        this.typeClassement = typeClassement;
        this.pays = pays;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getPointGagne() {
        return pointGagne;
    }

    public void setPointGagne(Integer pointGagne) {
        this.pointGagne = pointGagne;
    }

    public Integer getPointPerdu() {
        return pointPerdu;
    }

    public void setPointPerdu(Integer pointPerdu) {
        this.pointPerdu = pointPerdu;
    }

    public Integer getPointNul() {
        return pointNul;
    }

    public void setPointNul(Integer pointNul) {
        this.pointNul = pointNul;
    }

    public String getTypeClassement() {
        return typeClassement;
    }

    public void setTypeClassement(String typeClassement) {
        this.typeClassement = typeClassement;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public List<Journee> getJournees() {
        return journees;
    }

    public void setJournees(List<Journee> journees) {
        this.journees = journees;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Championat{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", logo='").append(logo).append('\'');
        sb.append(", dateDebut=").append(dateDebut);
        sb.append(", dateFin=").append(dateFin);
        sb.append(", pointGagne=").append(pointGagne);
        sb.append(", pointPerdu=").append(pointPerdu);
        sb.append(", pointNul=").append(pointNul);
        sb.append(", typeClassement='").append(typeClassement).append('\'');
        sb.append(", pays=").append(pays);
        sb.append(", equipes=").append(equipes);
        sb.append(", journees=").append(journees);
        sb.append('}');
        return sb.toString();
    }
}
