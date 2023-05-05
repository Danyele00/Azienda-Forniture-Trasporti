package com.ih.AziendaTraslochi.ihAziendaTraslochi.controller;

import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Cliente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Deposito;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Dipendente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.service.ClienteService;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.service.DepositoService;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MyController {
    @Autowired
    ClienteService clienteService;
    @Autowired
    DipendenteService dipendenteService;
    @Autowired
    DepositoService depositoService;

    @RequestMapping("/")
    public String getHome(Model model){
        return "home";
    }
    @RequestMapping(value = "/cerca")
    public String cercaCliente(@RequestParam String nome, Model model) {

        Cliente cliente;
        Dipendente dipendente;
        Deposito deposito;

        List<Cliente> lista = new ArrayList<>();
        List<Dipendente> listaDip = new ArrayList<>();
        List<Deposito> listaDep = new ArrayList<>();
        if(nome.equals("")) return "redirect:/";

        if (isNumeric(nome)) {
            try {
                cliente = clienteService.findClienteById(Long.valueOf(nome));
                lista.add(cliente);

            }catch (RuntimeException ex){
                System.out.println(ex.getMessage());
            }
            try {
                dipendente = dipendenteService.findDipendenteById(Long.valueOf(nome));
                listaDip.add(dipendente);
            }catch (RuntimeException ex){
                System.out.println(ex.getMessage());
            }
            try {
                deposito = depositoService.findDepositoById(Long.valueOf(nome));
                listaDep.add(deposito);
            }catch (RuntimeException ex){
                System.out.println(ex.getMessage());
            }
            }

        lista.addAll(clienteService.findClienteByNome(nome));
        listaDip.addAll(dipendenteService.findDipendenteByNome(nome));
        listaDep.addAll(depositoService.findDepositoByDesc(nome));

        model.addAttribute("listaClienti", lista);
        model.addAttribute("listaDipendenti",listaDip);
        model.addAttribute("listaDepositi",listaDep);

        return "trovato";
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            long d = Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
