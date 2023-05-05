package com.ih.AziendaTraslochi.ihAziendaTraslochi.service;

import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Cliente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Deposito;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.repository.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepositoServiceImpl  implements DepositoService{

    @Autowired
    DepositoRepository  depositoRepository;

    @Autowired
    ClienteService clienteService;

    @Override
    public Deposito findDepositoById(Long id) {
        Deposito deposito= null;
        Optional<Deposito> optional=depositoRepository.findById(id);
        if(optional.isPresent()){
            deposito = optional.get();
        }else {
            throw new RuntimeException("Attenzzione a quello chefai te lo detto");
        }
        return deposito;
    }

    @Override
    public List<Deposito> findAllDepositi() {
        return depositoRepository.findAll();
    }

    @Override
    public void addDeposito(Deposito deposito) {
    depositoRepository.save(deposito);
    }

    @Override
    public List<Deposito> findDepositoByDesc(String desc) {

        List<Deposito> lista = findAllDepositi();

        List<Deposito> result = new ArrayList<>();

        for(Deposito deposito : lista){
            if(deposito.getDescrizione().toLowerCase().contains(desc.toLowerCase())){
                result.add(deposito);
            }
        }
        return result;

    }

    @Override
    public void deleteDeposito(Long id) {
        depositoRepository.deleteById(id);

    }



}
