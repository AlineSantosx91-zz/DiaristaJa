package br.com.diaristaja.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diaristaja.model.Restricao;
import br.com.diaristaja.service.RestricaoService;
import br.com.diaristaja.validators.Result;

@RestController
@RequestMapping("diarista")
public class RestricaoController {
	
	RestricaoService restricaoService;
	
	
	@RequestMapping( value = "", method= RequestMethod.GET)
	public Result<Restricao> findAll(){
		return restricaoService.findAll();
	}
	
	@RequestMapping( value = "", method= RequestMethod.POST)
	public Result<Restricao> create(@RequestBody Restricao diarista){
		return restricaoService.save(diarista);
	}
	
	@RequestMapping( value = "/{id}", method= RequestMethod.GET)
	public Result<Restricao> findById(@PathVariable Long id){
		return restricaoService.findOne(id);
	}
	
	@RequestMapping( value = "/{id}", method= RequestMethod.PUT)
	public Result<Restricao> update(@PathVariable Long id, @RequestBody Restricao restricao){
		return restricaoService.update(restricao, id);
	}
	
	@RequestMapping( value = "/{id}", method= RequestMethod.DELETE)
	public Result<Restricao> delete(@PathVariable Long id){
		return restricaoService.delete(id);
	}

}
