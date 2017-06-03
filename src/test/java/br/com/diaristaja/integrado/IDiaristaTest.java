package br.com.diaristaja.integrado;

import br.com.diaristaja.model.Diarista;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IDiaristaTest {

	@POST("/diarista/")
	Call<Diarista> create(@Body Diarista diarista);

}
