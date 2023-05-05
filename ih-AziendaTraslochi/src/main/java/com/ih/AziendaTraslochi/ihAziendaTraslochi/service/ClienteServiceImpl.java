package com.ih.AziendaTraslochi.ihAziendaTraslochi.service;

import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Cliente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public Cliente findClienteById(Long id) {

        Optional<Cliente> optional = clienteRepository.findById(id);
        Cliente cliente = null;

        if(optional.isPresent()){
            cliente = optional.get();
        }else{
            throw new RuntimeException("errore da non sottovalutare!!!!");
        }

        return cliente;
    }

    @Override
    public List<Cliente> findAllClienti() {
        return clienteRepository.findAll();
    }

    @Override
    public void addCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findClienteByNome(String nome) {
        List<Cliente> lista = findAllClienti();

        List<Cliente> result = new ArrayList<>();

        for(Cliente cliente : lista){
            if(cliente.getNome().toLowerCase().contains(nome.toLowerCase())||
                    cliente.getCognome().toLowerCase().contains(nome.toLowerCase())){
                result.add(cliente);
            }
        }
        return result;
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }



}
