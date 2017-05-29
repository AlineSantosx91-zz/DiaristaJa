package br.com.diaristaja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.diaristaja.model.Diarista;

public interface DiaristaRepository extends JpaRepository<Diarista, Long> {

}
