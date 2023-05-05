package com.ih.AziendaTraslochi.ihAziendaTraslochi.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nome;
    private String cognome;

    @OneToMany(mappedBy = "cliente",orphanRemoval = true,targetEntity = Deposito.class)
    private List<Deposito> listaDepositi;


    public Cliente() {
    }

    public Cliente(Long idCliente, String nome, String cognome, List<Deposito> listaDepositi) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cognome = cognome;
        this.listaDepositi = listaDepositi;
    }

    public Cliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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

    public List<Deposito> getListaDepositi() {
        return listaDepositi;
    }

    public void setListaDepositi(List<Deposito> listaDepositi) {
        this.listaDepositi = listaDepositi;
    }
}
