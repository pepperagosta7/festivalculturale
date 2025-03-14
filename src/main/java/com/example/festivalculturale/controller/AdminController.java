package com.example.festivalculturale.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.festivalculturale.model.Evento;
import com.example.festivalculturale.model.Prenotazione;
import com.example.festivalculturale.service.EventoService;
import com.example.festivalculturale.service.PrenotazioneService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final EventoService eventoService;
    private final PrenotazioneService prenotazioneService;

    @GetMapping("/gestione-eventi")
    public String showEventi(Model model) {
        List<Evento> eventi = eventoService.showAll();
        model.addAttribute("eventi", eventi);
        return "admin/gestioneEventi";
    }

    @GetMapping("/eventi/nuovo")
    public String showFormNuovoEvento(Model model) {
        model.addAttribute("evento", new Evento());
        return "admin/formEvento";
    }

    @PostMapping("/eventi")
    public String createEvento(@ModelAttribute Evento evento) {
        eventoService.aggiungiEvento(evento);
        return "redirect:/admin/gestione-eventi";
    }

    @GetMapping("/eventi/modifica/{id}")
    public String showFormModificaEvento(@PathVariable Long id, Model model) {
        Evento evento = eventoService.cercaPerId(id)
                .orElseThrow(() -> new IllegalArgumentException("Evento non trovato con ID: " + id));
        model.addAttribute("evento", evento);
        return "admin/formEvento";
    }

    @PostMapping("/eventi/modifica/{id}")
    public String modifyEvento(@PathVariable Long id, @ModelAttribute Evento evento) {
        eventoService.updateEvento(id, evento);
        return "redirect:/admin/gestione-eventi";
    }

    @PostMapping("/eventi/elimina/{id}")
    public String eliminaEvento(@PathVariable Long id) {
        eventoService.elimina(id);
        return "redirect:/admin/gestione-eventi";
    }

    @GetMapping("/gestione-prenotazioni")
    public String showPrenotazioni(Model model) {
        List<Prenotazione> prenotazioni = prenotazioneService.showAllPrenotazioni();
        model.addAttribute("prenotazioni", prenotazioni);
        return "admin/gestionePrenotazioni";
    }

    @GetMapping("/dashboard")
    public String dashboardAdmin() {
        return "admin/dashboardAdmin";
    }

}
