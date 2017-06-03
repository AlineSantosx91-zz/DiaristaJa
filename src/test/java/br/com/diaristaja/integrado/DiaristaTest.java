package br.com.diaristaja.integrado;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.diaristaja.model.Diarista;
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
		diarista.email = "aline@gmail.com";
		diarista.password = "12345";
		diarista.nome = "Aline";
		diarista.sobreNome = "Santos";
		diarista.dataNascimento = new Date();
		diarista.documento = "45444369";
		diarista.valorMaximoDiaria = 200.0f;
		diarista.valorMinimoDiaria = 150.0f;

		IDiaristaTest diaristaTest = retrofit.create(IDiaristaTest.class);

		Call<Diarista> call = diaristaTest.create(diarista);
		Diarista response = call.execute().body();
		assertNotNull(response);
		assertNotNull(response.getId());
	}

}
