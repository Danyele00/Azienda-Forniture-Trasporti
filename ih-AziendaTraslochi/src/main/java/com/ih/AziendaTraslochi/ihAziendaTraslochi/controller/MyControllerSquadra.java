package com.ih.AziendaTraslochi.ihAziendaTraslochi.controller;


import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Cliente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Deposito;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Dipendente;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.model.Squadra;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.repository.DipendenteRepository;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.service.DipendenteService;
import com.ih.AziendaTraslochi.ihAziendaTraslochi.service.SquadraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/squadra")
public class MyControllerSquadra {

    @Autowired
    SquadraService squadraService;

    @Autowired
    DipendenteService dipendenteService;
    @Autowired
    private DipendenteRepository dipendenteRepository;

    @RequestMapping("/")
    public String getHome(Model model){
        return "home";
    }

    @RequestMapping("/newSquadra")
    public String aggiungiNewSquadra(Model model){
        Squadra squadra=new Squadra();

        model.addAttribute("dipendenti",dipendenteRepository.findAll());
        model.addAttribute("squadra", squadra);

        return "formSquadra";
    }
  /*  squadra/salvaSquadra/{idS}/{idL} (idS:${squadra.idSquadra} , idL:${dipendente.idDipendente})*/
    @PostMapping("squadra/salvaSquadra")
    public String saveSquadra(@ModelAttribute("squadra") Squadra squadra){


        squadraService.addSquadra(squadra);

        return "redirect:/";
    }

    /*squadra/newComponente/{dipendente.idDipendente}*/
    @RequestMapping("/squadra/newComponente/{idDipendente}")
    public String aggiungiComponenteSquadra(@ModelAttribute("squadra") Squadra squadra,
                                            @PathVariable(value ="idDipendente") Long idDipendente){

        Dipendente dipendente= dipendenteService.findDipendenteById(idDipendente);
        dipendente.getListaSquadre().add(squadra);
        squadra.getListaSquadra().add(dipendente);

        squadraService.addSquadra(squadra);
        dipendenteService.addDipendente(dipendente);
        return"redirect:/";
    }

    /*/newComponente/{idDipendente}*/
    @RequestMapping("/newComponente/{idDipendente}")
    public String aggiungiComponente(){
        return "";
    }






    @RequestMapping("/addLeaderSquadra/{idSquadra}/{idDip}")
    public String aggiungiLeaderSquadra(@PathVariable(value = "idSquadra") Long idSquadra,
                                   @PathVariable(value ="idDipendente") Long idDipendente){

        Squadra squadra= squadraService.findSquadraById(idSquadra);
        Dipendente dipendente= dipendenteService.findDipendenteById(idDipendente);

        squadra.setLeader(dipendente);
        dipendente.getListaSquadre().add(squadra);
        squadraService.addSquadra(squadra);
        dipendenteService.addDipendente(dipendente);
        return "redirect:/cliente/clienti";
    }




}
