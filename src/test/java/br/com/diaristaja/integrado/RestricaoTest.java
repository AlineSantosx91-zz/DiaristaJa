package br.com.diaristaja.integrado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.diaristaja.model.Restricao;
import br.com.diaristaja.validators.Result;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RestricaoTest {
	
	private Retrofit retrofit;
	
	@Before
	public void setUp() {

		retrofit = new Retrofit.Builder().baseUrl("http://localhost:8080")
				.addConverterFactory(JacksonConverterFactory.create()).build();
	}
	
	@Test
	public void cadastraRestricao() throws IOException{
		
		Restricao restricao = new Restricao();
		restricao.nome = "Limpar Vidro";
		
		IRestricaoTest restricaoTest = retrofit.create(IRestricaoTest.class);

		Call<Result<Restricao>> call = restricaoTest.create(restricao);
		Result<Restricao> response = call.execute().body();
		assertNotNull(response);
		assertEquals(response.getStatus(), 1);
		assertNotNull(response.getResult().getId());
		
	}

}
