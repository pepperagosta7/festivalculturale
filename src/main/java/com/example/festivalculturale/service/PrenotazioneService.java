package com.example.festivalculturale.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.festivalculturale.model.Evento;
import com.example.festivalculturale.model.Prenotazione;
import com.example.festivalculturale.model.Utente;
import com.example.festivalculturale.repository.EventoRepository;
import com.example.festivalculturale.repository.PrenotazioneRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;
    private final EventoRepository eventoRepository;

    public List<Prenotazione> showStorico(Utente utente) {
        return prenotazioneRepository.findByUtente(utente);
    }

    @Transactional
    public Prenotazione effettuaPrenotazione(Long eventoId, int numeroBiglietti, Utente utente) {

        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new IllegalArgumentException("Evento non trovato"));

        if (numeroBiglietti <= 0) {
            throw new IllegalArgumentException("Il numero di biglietti deve essere maggiore di 0");
        }

        Prenotazione prenotazione = Prenotazione.builder()
                .utente(utente)
                .evento(evento)
                .numeroBiglietti(numeroBiglietti)
                .dataPrenotazione(LocalDate.now())
                .build();

        return prenotazioneRepository.save(prenotazione);
    }

    @Transactional
    public void deletePrenotazione(Long prenotazioneId, Utente utente) {

        Prenotazione prenotazione = prenotazioneRepository.findById(prenotazioneId)
                .orElseThrow(() -> new IllegalArgumentException("Prenotazione non trovata"));

        if (!prenotazione.getUtente().getId().equals(utente.getId())) {
            throw new SecurityException("Non sei autorizzato a cancellare questa prenotazione");
        }

        prenotazioneRepository.delete(prenotazione);
    }

    public List<Prenotazione> showAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

}
