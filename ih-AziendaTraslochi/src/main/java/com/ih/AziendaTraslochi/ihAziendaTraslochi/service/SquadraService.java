package com.ih.AziendaTraslochi.ihAziendaTraslochi.service;



import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Squadra;

import java.util.List;


public interface SquadraService {

    Squadra findSquadraById(Long id);
    List<Squadra> findAllSquadre();

    void addSquadra(Squadra squadra);

    void deleteSquadraById(Long id);
}


