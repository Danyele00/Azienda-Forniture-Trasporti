package com.ih.AziendaTraslochi.ihAziendaTraslochi.service;

import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Cliente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Deposito;

import java.util.List;

public interface DepositoService {

    Deposito findDepositoById(Long id);
    List<Deposito> findAllDepositi();

    void addDeposito(Deposito deposito);

    public List<Deposito> findDepositoByDesc(String desc);

    void deleteDeposito(Long id);




}
