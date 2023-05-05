package com.ih.AziendaTraslochi.ihAziendaTraslochi.service;

import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Cliente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Dipendente;

import java.util.List;

public interface DipendenteService {

    Dipendente findDipendenteById(Long id);
    List<Dipendente> findAllDipendente();
    public List<Dipendente> findDipendenteByNome(String nome);
    void addDipendente(Dipendente dipendete);

    void deleteDipendente(Long id);
}
