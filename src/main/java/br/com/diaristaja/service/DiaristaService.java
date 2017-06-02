package br.com.diaristaja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.repository.DiaristaRepository;

@Service
public class DiaristaService {
	
	private final DiaristaRepository diaristaRepository;
	
	@Autowired
	public DiaristaService(DiaristaRepository diaristaRepository){
		this.diaristaRepository = diaristaRepository;
	}

	public List<Diarista> findAll() {
		return this.diaristaRepository.findAll();
	}

	public Diarista findOne(Long id) {
		return this.diaristaRepository.findOne(id);
	}

	public Diarista save(Diarista diarista) {
		return this.diaristaRepository.save(diarista);
	}

	public void delete(Diarista existingDiarista) {
		 this.diaristaRepository.delete(existingDiarista);	
	}

}
