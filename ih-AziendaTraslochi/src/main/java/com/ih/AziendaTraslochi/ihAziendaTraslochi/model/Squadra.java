package com.ih.AziendaTraslochi.ihAziendaTraslochi.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Squadra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSquadra;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "dipendenti_Project",
            joinColumns = { @JoinColumn(name = "dipendente_id") },
            inverseJoinColumns = { @JoinColumn(name = "squadra_id") }
    )
    private List<Dipendente> listaSquadra;

    private String descrizione;


    @ManyToOne
    @JoinColumn(name = "leader_id_dipendente")
    private Dipendente leader;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inizio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fine;

    public Dipendente getLeader() {
        return leader;
    }

    public void setLeader(Dipendente leader) {
        this.leader = leader;
    }

    public Squadra() {
    }

    public Squadra(Long idSquadra, List<Dipendente> listaSquadra, String descrizione, Dipendente leader, Date inizio, Date fine) {
        this.idSquadra = idSquadra;
        this.listaSquadra = listaSquadra;
        this.descrizione = descrizione;
        this.leader = leader;
        this.inizio = inizio;
        this.fine = fine;
    }

    public Long getIdSquadra() {
        return idSquadra;
    }

    public void setIdSquadra(Long idSquadra) {
        this.idSquadra = idSquadra;
    }

    public List<Dipendente> getListaSquadra() {
        return listaSquadra;
    }

    public void setListaSquadra(List<Dipendente> listaSquadra) {
        this.listaSquadra = listaSquadra;
    }

    public Date getInizio() {
        return inizio;
    }

    public void setInizio(Date inizio) {
        this.inizio = inizio;
    }

    public Date getFine() {
        return fine;
    }

    public void setFine(Date fine) {
        this.fine = fine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }



}
