package com.ipi.springfoot.pojos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Journee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Long idChampionat;

    @OneToMany(mappedBy = "journee")
    private List<Match> matches;

    @ManyToOne
    private Championat championat;

    public Journee() {
    }

    public Journee(Long id, Integer numero, Long idChampionat) {
        this.id = id;
        this.numero = numero;
        this.idChampionat = idChampionat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Long getIdChampionat() {
        return idChampionat;
    }

    public void setIdChampionat(Long idChampionat) {
        this.idChampionat = idChampionat;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Championat getChampionat() {
        return championat;
    }

    public void setChampionat(Championat championat) {
        this.championat = championat;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Journee{");
        sb.append("id=").append(id);
        sb.append(", numero=").append(numero);
        sb.append(", idChampoinat=").append(idChampionat);
        sb.append(", matches=").append(matches);
        sb.append(", championat=").append(championat);
        sb.append('}');
        return sb.toString();
    }
}
