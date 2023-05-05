package com.ih.AziendaTraslochi.ihAziendaTraslochi.controller;

import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Deposito;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Dipendente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dipendente")
public class MyControllerDipendente {

    @Autowired
    DipendenteService dipendenteService;

    @RequestMapping("/")
    public String getHome(Model model){
        return "home";
    }
    @RequestMapping("/newDipendente")
    public String aggiungiNewDipendente(Model model){
        Dipendente dipendente = new Dipendente();
        model.addAttribute("dipendente",dipendente);
        return "formDipendente";
    }


    @RequestMapping("/dipendenti")
    public String listaDipendenti(Model model){
        model.addAttribute("listaDipendenti", dipendenteService.findAllDipendente());
        return "/dipendenti";
    }

    @PostMapping("/salvaDipendente")
    public String saveDipendente(@ModelAttribute("dipendente") Dipendente dipendente) {
        dipendenteService.addDipendente(dipendente);
        return "redirect:/";
    }

    @RequestMapping("cancella/{id}")
    public String deleteCliente(@PathVariable(value="id")Long id, Model model){
        dipendenteService.deleteDipendente(id);
        return "redirect:/";
    }
}
