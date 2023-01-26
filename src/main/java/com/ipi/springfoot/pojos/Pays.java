package com.ipi.springfoot.pojos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String logo;

    @OneToMany(mappedBy = "pays")
    private List<Championat> championats;

    public Pays() {
    }

    public Pays(String nom, String logo) {
        this.nom = nom;
        this.logo = logo;
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

    public List<Championat> getChampionats() {
        return championats;
    }

    public void setChampionats(List<Championat> championats) {
        this.championats = championats;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pays{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", logo='").append(logo).append('\'');
        sb.append(", championats=").append(championats);
        sb.append('}');
        return sb.toString();
    }
}
