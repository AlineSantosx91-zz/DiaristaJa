package br.com.diaristaja.integrado;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.model.Endereco;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class DiaristaTest {

	private Retrofit retrofit;

	@Before
	public void setUp() {

		retrofit = new Retrofit.Builder().baseUrl("http://localhost:8080")
				.addConverterFactory(JacksonConverterFactory.create()).build();
	}

	@Test
	public void CadastraDiarista() throws IOException {
		
		Diarista diarista = new Diarista();
		diarista.email = "teste@gmail.com";
		diarista.documento = "677";
		diarista.password = "12345";
		diarista.nome = "Aline";
		diarista.sobreNome = "Santos";
		diarista.dataNascimento = new Date();
		diarista.ddd1 = "11";
		diarista.numero1 = "977776666";
		diarista.ddd2 = "11";
		diarista.numero2 = "65443222";
		diarista.valorMaximoDiaria = 200.0f;
		diarista.valorMinimoDiaria = 150.0f;
		
		Endereco endereco = new Endereco();
		endereco.cep= "08540510";
		endereco.cidade = "São Paulo";
		endereco.estado = "São Paulo";
		endereco.endereco = "Rua Dez";
		endereco.numero = "22";
		endereco.referencia = "Bloco B";
		endereco.latitude = "-23.5406338";
		endereco.longitude = "-46.6342854";
	
		diarista.endereco = endereco;

		IDiaristaTest diaristaTest = retrofit.create(IDiaristaTest.class);

		Call<Diarista> call = diaristaTest.create(diarista);
		Diarista response = call.execute().body();
		assertNotNull(response);
		assertNotNull(response.getId());
	}

}
