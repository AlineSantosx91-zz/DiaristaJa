package br.com.diaristaja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diaristaja.model.Restricao;
import br.com.diaristaja.repository.RestricaoRepository;
import br.com.diaristaja.validators.Result;
import br.com.diaristaja.validators.Validator;

@Service
public class RestricaoService {
	
	private final RestricaoRepository restricaoRepository;
	Result<Restricao> result = null;

	@Autowired
	public RestricaoService(RestricaoRepository restricaoRepository) {
		this.restricaoRepository = restricaoRepository;
	}

	public Result<Restricao> findAll() {

		Result<Restricao> result = null;
		result = new Result<Restricao>(this.restricaoRepository.findAll());
		return result;
	}

	public Result<Restricao> findOne(Long id) {

		result = new Result<Restricao>(this.restricaoRepository.findOne(id));
		return result;
	}

	public Result<Restricao> save(Restricao restricao) {

		List<Validator> validators = new ArrayList<Validator>();

		if (validators.size() > 0) {
			return new Result<Restricao>(0, validators);
		}

		result = new Result<Restricao>(this.restricaoRepository.save(restricao));
		return result;
	}

	public Result<Restricao> delete(Long id) {

		Restricao existingRestricao = restricaoRepository.findOne(id);
		List<Validator> validators = new ArrayList<Validator>();

		if (existingRestricao == null) {
			validators.add(new Validator("Erro ao remover, por favor tente novamente"));
		}

		restricaoRepository.delete(id);
		result = new Result<Restricao>(existingRestricao);
		return result;

	}

	public Result<Restricao> update(Restricao restricao, Long id) {

		Restricao existingRestricao = restricaoRepository.findOne(id);
		BeanUtils.copyProperties(restricao, existingRestricao);

		result = new Result<Restricao>(this.restricaoRepository.save(restricao));
		return result;
	}


}
