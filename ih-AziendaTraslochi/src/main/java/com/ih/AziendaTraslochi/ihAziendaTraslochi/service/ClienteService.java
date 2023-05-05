package com.ih.AziendaTraslochi.ihAziendaTraslochi.service;

import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente findClienteById(Long id);
    List<Cliente> findAllClienti();

    void addCliente(Cliente cliente);

    public List<Cliente> findClienteByNome(String nome);

    void deleteCliente(Long id);




}
