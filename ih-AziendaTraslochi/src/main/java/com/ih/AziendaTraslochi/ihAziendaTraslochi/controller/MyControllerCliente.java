package com.ih.AziendaTraslochi.ihAziendaTraslochi.controller;

import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Cliente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Deposito;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.repository.ClienteRepository;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.repository.DepositoRepository;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.service.ClienteService;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.service.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class MyControllerCliente {
    @Autowired
    ClienteService clienteService;
    @Autowired
    DepositoService depositoService;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    DepositoRepository depositoRepository;

    @RequestMapping("/")
    public String getHome(Model model){
        return "home";
    }
    @RequestMapping("/newCliente")
    public String aggiungiNewCliente(Model model){

        Cliente cliente = new Cliente();
        List<Deposito> listaDep= depositoService.findAllDepositi();

        model.addAttribute("cliente",cliente);
        model.addAttribute("depositi",depositoService.findAllDepositi());
        model.addAttribute("listaDep", listaDep);

        return "formCliente";
    }
    @RequestMapping("/clienti")
    public String listaClienti(Model model){

        List<Deposito> listaDep= depositoService.findAllDepositi();
        Deposito deposito2= new Deposito();

        model.addAttribute("listaClienti", clienteService.findAllClienti());
        model.addAttribute("listaDep", listaDep);
        model.addAttribute("deposito2",deposito2);
        return "/clienti";
    }

    @RequestMapping("cancella/{id}")
    public String deleteCliente(@PathVariable(value="id")Long id, Model model){
        clienteService.deleteCliente(id);
        return "redirect:/";
    }
    @GetMapping("/aggiorna/{id}")
    public String updatePersone(@PathVariable(value = "id") Long id,Model model) {

        Cliente cliente = clienteService.findClienteById(id);

        model.addAttribute("cliente", cliente);
        clienteService.deleteCliente(id);

        return "formCliente";
    }


    @PostMapping("/salvaCliente")
    public String saveCliente(@ModelAttribute("cliente") Cliente cliente) {


        clienteService.addCliente(cliente);
        return "redirect:/";
    }
    @RequestMapping("/addDeposito/{idCliente}/{idDep}")
    public String aggiungiDeposito(@PathVariable(value = "idCliente") Long idCliente,
                                   @PathVariable(value ="idDep") Long idDep){

        Cliente cliente=clienteService.findClienteById(idCliente);
        Deposito deposito= depositoService.findDepositoById(idDep);


        deposito.setCliente(cliente);
        cliente.getListaDepositi().add(deposito);

        clienteService.addCliente(cliente);
        depositoService.addDeposito(deposito);
        return "redirect:/cliente/clienti";
    }

    /*"@{deleteDeposito/{idCliente}/{idDep} (idCliente=${cliente.idCliente}, idDep=${deposito.idDep}) }"*/
    @RequestMapping("/deleteDeposito/{idCliente}/{idDep}")
    public String rimuoviDepositoById(@PathVariable(value = "idCliente") Long idCliente,
                                   @PathVariable(value ="idDep") Long idDep){

        Cliente cliente=clienteService.findClienteById(idCliente);
        Deposito deposito= depositoService.findDepositoById(idDep);


        deposito.setCliente(null);
        cliente.getListaDepositi().remove(deposito);

        clienteService.addCliente(cliente);
        depositoService.addDeposito(deposito);
        return "redirect:/cliente/clienti";

    }
}
