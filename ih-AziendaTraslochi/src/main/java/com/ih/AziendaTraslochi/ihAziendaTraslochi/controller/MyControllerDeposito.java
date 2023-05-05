package com.ih.AziendaTraslochi.ihAziendaTraslochi.controller;

import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Cliente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Deposito;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.service.ClienteService;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.service.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deposito")
public class MyControllerDeposito {

    @Autowired
    private DepositoService depositoService;
    @Autowired
    private ClienteService clienteService;

    @RequestMapping("/")
    public String getHome(Model model){
        return "home";
    }
    @RequestMapping("/newDeposito")
    public String aggiungiNewDeposito(Model model){
        Deposito deposito = new Deposito();
        model.addAttribute("deposito",deposito);
        return "formDeposito";
    }
    @RequestMapping("/depositi")
    public String listaDepositi(Model model){
        model.addAttribute("listaDepositi", depositoService.findAllDepositi());
        return "/depositi";
    }
    @PostMapping("/salvaDeposito")
    public String saveDeposito(@ModelAttribute("deposito") Deposito deposito) {
        depositoService.addDeposito(deposito);
        return "redirect:/";
    }

    @RequestMapping("cancella/{id}")
    public String deleteCliente(@PathVariable(value="id")Long id, Model model){
        depositoService.deleteDeposito(id);
        return "redirect:/";
    }

    @GetMapping("/aggiorna/{id}")
    public String updateDeposito(@PathVariable(value = "id") Long id,Model model) {

        Deposito deposito = depositoService.findDepositoById(id);

        model.addAttribute("deposito", deposito);
        depositoService.deleteDeposito(id);

        return "formDeposito";
    }




}
