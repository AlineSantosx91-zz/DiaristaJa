package br.com.diaristaja.integrado;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import br.com.diaristaja.enumeration.RestricaoEnum;
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
		diarista.email = geraEmail();
		diarista.documento = geraCPF();
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

//		diarista.restricoes = RestricaoEnum.LAVAR_ROUPA.getValor() + "," + 
//		RestricaoEnum.PASSAR_ROUPA.getValor();

		Endereco endereco = new Endereco();
		endereco.cep = "08540510";
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

	private String geraCPF() {
		String iniciais = "";
		Integer numero;
		for (int i = 0; i < 9; i++) {
			numero = new Integer((int) (Math.random() * 10));
			iniciais += numero.toString();
		}
		return iniciais + "87";
	}

	private String geraEmail() {
		Random random = new Random();
		int number = random.nextInt(1000);
		return String.format("%03d", number).concat("@gmail.com");
	}

}
