package com.ipi.springfoot.pojos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Stade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private Integer capacite;
    private String telephone;

    @OneToMany(mappedBy = "stade")
    private List<Equipe> equipes;

    @OneToMany(mappedBy = "stade")
    private List<Match> matches;

    public Stade() {
    }

    public Stade(String nom, String adresse, Integer capacite, String telephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.capacite = capacite;
        this.telephone = telephone;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stade{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", adresse='").append(adresse).append('\'');
        sb.append(", capacite=").append(capacite);
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", equipes=").append(equipes);
        sb.append(", matches=").append(matches);
        sb.append('}');
        return sb.toString();
    }
}
