package com.example.festivalculturale.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.festivalculturale.model.Evento;
import com.example.festivalculturale.repository.EventoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;

    public List<Evento> showAll() {
        return eventoRepository.findAll();
    }

    public Evento aggiungiEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Optional<Evento> cercaPerId(Long id) {
        return eventoRepository.findById(id);
    }

    public Evento updateEvento(Long id, Evento evento) {
        Evento esistente = eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento non trovato con ID: " + id));

        esistente.setTitolo(evento.getTitolo());
        esistente.setData(evento.getData());
        esistente.setPrezzo(evento.getPrezzo());

        return eventoRepository.save(esistente);
    }

    public void elimina(Long id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento non trovato con ID: " + id));
        eventoRepository.delete(evento);
    }

    public List<Evento> cercaPerData(LocalDate data) {
        return eventoRepository.findByData(data);
    }

    public List<Evento> cercaPerPrezzo(Double prezzoMin, Double prezzoMax) {
        return eventoRepository.findByPrezzoBetween(prezzoMin, prezzoMax);
    }
}
