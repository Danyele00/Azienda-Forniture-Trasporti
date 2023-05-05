package com.ih.AziendaTraslochi.ihAziendaTraslochi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDipendente;
    private String nome;
    private String cognome;

    @ManyToMany(mappedBy = "listaSquadra")
    private List<Squadra> listaSquadre;

    public Dipendente() {
    }

    public Dipendente(Long idDipendente, String nome, String cognome, List<Squadra> listaSquadre) {
        this.idDipendente = idDipendente;
        this.nome = nome;
        this.cognome = cognome;

        this.listaSquadre = listaSquadre;
    }

    public Long getIdDipendente() {
        return idDipendente;
    }

    public void setIdDipendente(Long idDipendente) {
        this.idDipendente = idDipendente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    public List<Squadra> getListaSquadre() {
        return listaSquadre;
    }

    public void setListaSquadre(List<Squadra> listaSquadre) {
        this.listaSquadre = listaSquadre;
    }
}
