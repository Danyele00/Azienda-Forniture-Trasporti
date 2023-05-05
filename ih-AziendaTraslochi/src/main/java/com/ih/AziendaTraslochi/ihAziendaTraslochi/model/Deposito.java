package com.ih.AziendaTraslochi.ihAziendaTraslochi.model;


import jakarta.persistence.*;

@Entity
public class Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDep;


    private String descrizione;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    public Deposito() {
    }

    public Deposito(Long idDep, String descrizione, Cliente cliente) {
        this.idDep = idDep;
        this.descrizione = descrizione;
        this.cliente = cliente;
    }

    public Long getIdDep() {
        return idDep;
    }

    public void setIdDep(Long idDep) {
        this.idDep = idDep;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
