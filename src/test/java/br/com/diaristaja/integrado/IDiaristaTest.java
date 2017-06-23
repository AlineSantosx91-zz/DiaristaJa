package br.com.diaristaja.integrado;

import java.util.List;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.model.Restricao;
import br.com.diaristaja.validators.Result;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IDiaristaTest {

	@POST("/diarista/")
	Call<Result<Diarista>> create(@Body Diarista diarista);
	
	@POST("/diarista/filtro")
	Call<Result<Diarista>> filterPorRestricao(@Body List<Restricao> restricoes);
	
	

}
