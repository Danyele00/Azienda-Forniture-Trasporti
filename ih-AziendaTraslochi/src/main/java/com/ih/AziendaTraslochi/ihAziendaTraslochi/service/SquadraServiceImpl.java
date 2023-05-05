package com.ih.AziendaTraslochi.ihAziendaTraslochi.service;


import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Squadra;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.repository.SquadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SquadraServiceImpl implements SquadraService{


    @Autowired
    SquadraRepository squadraRepository;

    @Override
    public Squadra findSquadraById(Long id) {
        Optional<Squadra> optional = squadraRepository.findById(id);

        Squadra squadra= new Squadra();
        if(optional.isPresent()){
            squadra=optional.get();
        }
        return squadra;
    }

    @Override
    public List<Squadra> findAllSquadre() {
        return squadraRepository.findAll();
    }

    @Override
    public void addSquadra(Squadra squadra) {
         squadraRepository.save(squadra);
    }

    @Override
    public void deleteSquadraById(Long id) {
        squadraRepository.deleteById(id);
    }
}
