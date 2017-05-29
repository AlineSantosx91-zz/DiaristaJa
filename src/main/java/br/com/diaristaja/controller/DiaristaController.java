package br.com.diaristaja.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.repository.DiaristaRepository;

@RestController
@RequestMapping("diarista")
public class DiaristaController {
	
	@Autowired
	DiaristaRepository diaristaRepository;
	
	@RequestMapping( value = "/teste", method= RequestMethod.GET)
	public String home(){
		return "Teste diaristas!";
	}
	
	@RequestMapping( value = "/", method= RequestMethod.GET)
	public List<Diarista> findAll(){
		return diaristaRepository.findAll();
	}
	
	@RequestMapping( value = "/", method= RequestMethod.POST)
	public Diarista create(@RequestBody Diarista diarista){
		return diaristaRepository.saveAndFlush(diarista);
	}
	
	@RequestMapping( value = "/{id}", method= RequestMethod.GET)
	public Diarista findById(@PathVariable Long id){
		return diaristaRepository.findOne(id);
	}
	
	@RequestMapping( value = "/{id}", method= RequestMethod.PUT)
	public Diarista update(@PathVariable Long id, @RequestBody Diarista diarista){
		Diarista existingDiarista = diaristaRepository.findOne(id);
		BeanUtils.copyProperties(diarista, existingDiarista);
		return diaristaRepository.saveAndFlush(diarista);
	}
	
	@RequestMapping( value = "/{id}", method= RequestMethod.DELETE)
	public Diarista delete(@PathVariable Long id){
		Diarista existingDiarista = diaristaRepository.findOne(id);
		diaristaRepository.delete(existingDiarista);
		return existingDiarista;
	}

}
