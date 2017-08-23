package br.com.diaristaja.integrado;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.model.Endereco;
import br.com.diaristaja.model.FiltroLocalizacao;
import br.com.diaristaja.validators.Result;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IDiaristaTest {

	@POST("/diaristas/")
	Call<Result<Diarista>> create(@Body Diarista diarista);
	
	@POST("/diaristas/filtro/avancado")
	Call<Result<Diarista>> filterAvancado(@Body FiltroLocalizacao filtroLocalizacao);
	
	@POST("/diaristas/filtro/localizacao")
	Call<Result<Diarista>> filterPorLocalizacao(@Body Endereco endereco);

}
