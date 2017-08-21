package br.com.diaristaja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.model.FiltroLocalizacao;
import br.com.diaristaja.repository.DiaristaRepository;
import br.com.diaristaja.repository.EnderecoRepository;
import br.com.diaristaja.validators.Result;
import br.com.diaristaja.validators.Validator;

@Service
public class DiaristaService {

	private final DiaristaRepository diaristaRepository;
	private final EnderecoRepository enderecoRepository;
	Result<Diarista> result = null;

	@Autowired
	public DiaristaService(DiaristaRepository diaristaRepository, EnderecoRepository enderecoRepository) {
		this.diaristaRepository = diaristaRepository;
		this.enderecoRepository = enderecoRepository;
	}

	public Result<Diarista> findAll() {

		Result<Diarista> result = null;
		result = new Result<Diarista>(this.diaristaRepository.findAll());
		return result;
	}

	public Result<Diarista> findOne(Long id) {

		result = new Result<Diarista>(this.diaristaRepository.findOne(id));
		return result;
	}

	public Result<Diarista> save(Diarista diarista) {

		List<Validator> validators = new ArrayList<Validator>();

		if (diarista.getEmail() == null) {
			validators.add(new Validator("E-mail é obrigatório"));
		}

		if (diarista.getNome() == null) {
			validators.add(new Validator("Nome é obrigatório"));
		}

		if (diarista.getDocumento() == null) {
			validators.add(new Validator("Documento é obrigatório"));
		}

		if (validators.size() > 0) {
			return new Result<Diarista>(0, validators);
		}

		result = new Result<Diarista>(this.diaristaRepository.save(diarista));
		return result;
	}

	public Result<Diarista> delete(Long id) {

		Diarista existingDiarista = diaristaRepository.findOne(id);
		List<Validator> validators = new ArrayList<Validator>();

		if (existingDiarista == null) {
			validators.add(new Validator("Erro ao remover, por favor tente novamente"));
		}

		diaristaRepository.delete(id);
		result = new Result<Diarista>(existingDiarista);
		return result;

	}

	public Result<Diarista> update(Diarista diarista, Long id) {

		Diarista existingDiarista = diaristaRepository.findOne(id);
		BeanUtils.copyProperties(diarista, existingDiarista);

		result = new Result<Diarista>(this.diaristaRepository.save(diarista));
		return result;
	}

	public Result<Diarista> getDiaristasFiltradasPorRestricao(List<Long> restricoesId) {

		return new Result<Diarista>(this.diaristaRepository.getDiaristasFiltradasPorRestricao(restricoesId));
	}

	public Result<Diarista> getDiaristasFiltradasPorLocalizacao(FiltroLocalizacao filtroLocalizacao){
				
		List<Long> list = this.enderecoRepository.getEnderecosByLatLong(filtroLocalizacao.getLatitude(), filtroLocalizacao.getLongitude(), filtroLocalizacao.getRaio());
		
		return new Result<Diarista>(this.diaristaRepository.getDiaristasFiltradasPorLocalizacao(list));
	}

}
