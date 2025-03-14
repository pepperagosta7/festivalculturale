package com.example.festivalculturale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.festivalculturale.model.Prenotazione;
import com.example.festivalculturale.model.Utente;
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    @Query("SELECT p FROM Prenotazione p JOIN FETCH p.evento e WHERE p.utente = :utente")
    List<Prenotazione> findByUtente(Utente utente);

    void deleteByIdAndUtente(Long id, Utente utente);
}
