package br.com.diaristaja.integrado;

import br.com.diaristaja.model.Restricao;
import br.com.diaristaja.validators.Result;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IRestricaoTest {
	
	@POST("/restricao/")
	Call<Result<Restricao>> create(@Body Restricao restricao);

}
