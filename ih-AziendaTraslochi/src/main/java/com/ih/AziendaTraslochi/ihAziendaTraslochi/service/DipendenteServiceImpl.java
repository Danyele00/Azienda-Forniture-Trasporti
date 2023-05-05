package com.ih.AziendaTraslochi.ihAziendaTraslochi.service;

import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Cliente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Dipendente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DipendenteServiceImpl implements DipendenteService{

    @Autowired
    DipendenteRepository dipendenteRepository;

    @Override
    public Dipendente findDipendenteById(Long id) {
        Dipendente dipendente = new Dipendente();
        Optional<Dipendente> optional=dipendenteRepository.findById(id);

        if(optional.isPresent()) dipendente=optional.get();
        else throw new RuntimeException("anzzztenio !!");
        return dipendente;
    }

    @Override
    public List<Dipendente> findDipendenteByNome(String nome) {
        List<Dipendente> lista = findAllDipendente();

        List<Dipendente> result = new ArrayList<>();

        for(Dipendente dipendente : lista){
            if(dipendente.getNome().toLowerCase().contains(nome.toLowerCase())||
                    dipendente.getCognome().toLowerCase().contains(nome.toLowerCase())){
                result.add(dipendente);
            }
        }
        return result;
    }

    @Override
    public List<Dipendente> findAllDipendente() {
        return dipendenteRepository.findAll();
    }

    @Override
    public void addDipendente(Dipendente dipendete) {
        dipendenteRepository.save(dipendete);
    }

    @Override
    public void deleteDipendente(Long id) {
        dipendenteRepository.deleteById(id);
    }
}
