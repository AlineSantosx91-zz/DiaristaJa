package br.com.diaristaja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.service.DiaristaService;
import br.com.diaristaja.validators.Result;

@RestController
@RequestMapping("diarista")
public class DiaristaController {
	
	private final DiaristaService diaristaService;
	
	@Autowired
	public DiaristaController(DiaristaService diaristaService){
		this.diaristaService = diaristaService;
	}
	
	@RequestMapping( value = "/teste", method= RequestMethod.GET)
	public String home(){
		return "Teste diaristas!";
	}
	
	@RequestMapping( value = "", method= RequestMethod.GET)
	public Result<Diarista> findAll(){
		return diaristaService.findAll();
	}
	
	@RequestMapping( value = "", method= RequestMethod.POST)
	public Result<Diarista> create(@RequestBody Diarista diarista){
		return diaristaService.save(diarista);
	}
	
	@RequestMapping( value = "/{id}", method= RequestMethod.GET)
	public Result<Diarista> findById(@PathVariable Long id){
		return diaristaService.findOne(id);
	}
	
	@RequestMapping( value = "/{id}", method= RequestMethod.PUT)
	public Result<Diarista> update(@PathVariable Long id, @RequestBody Diarista diarista){
		return diaristaService.update(diarista, id);
	}
	
	@RequestMapping( value = "/{id}", method= RequestMethod.DELETE)
	public Result<Diarista> delete(@PathVariable Long id){
		return diaristaService.delete(id);
	}

}
