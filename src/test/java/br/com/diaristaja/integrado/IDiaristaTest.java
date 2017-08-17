package br.com.diaristaja.integrado;

import java.util.List;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.model.Endereco;
import br.com.diaristaja.validators.Result;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IDiaristaTest {

	@POST("/diaristas/")
	Call<Result<Diarista>> create(@Body Diarista diarista);
	
	@POST("/diaristas/filtro/restricao")
	Call<Result<Diarista>> filterPorRestricao(@Body List<Long> restricoes);
	
	@POST("/diaristas/filtro/localizacao")
	Call<Result<Diarista>> filterPorLocalizacao(@Body Endereco endereco);

}
