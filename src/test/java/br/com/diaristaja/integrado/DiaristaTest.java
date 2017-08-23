package br.com.diaristaja.integrado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.model.Endereco;
import br.com.diaristaja.model.FiltroLocalizacao;
import br.com.diaristaja.model.Restricao;
import br.com.diaristaja.validators.Result;
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

	public void CadastraDiarista() throws IOException {

		Diarista diarista = new Diarista();
		diarista.setEmail(geraEmail());
		diarista.setDocumento(geraCPF());
		diarista.setPassword("12345");
		diarista.setNome("Aline");
		diarista.setSobreNome("Santos");
		diarista.setDataNascimento(new Date());
		diarista.setDdd1("11");
		diarista.setNumero1("977776666");
		diarista.setDdd2("11");
		diarista.setNumero2("65443222");
		diarista.setValorMaximoDiaria(200.0f);
		diarista.setValorMinimoDiaria(150.0f);


		Restricao restricao1 = new Restricao();
		restricao1.setNome("Lavar Roupa");

		Restricao restricao2 = new Restricao();
		restricao2.setNome("Limpar vidro");

		Restricao restricao3 = new Restricao();
		restricao3.setNome("Lavar Louça");

		Restricao restricao4 = new Restricao();
		restricao4.setNome("Passar Roupa");

		List<Restricao> restricoes = new ArrayList<Restricao>();

		restricoes.add(restricao1);
		restricoes.add(restricao2);
		restricoes.add(restricao3);
		restricoes.add(restricao4);

//		diarista.restricoes = restricoes;

		Endereco endereco = new Endereco();
		endereco.setCep("08540510");
		endereco.setCidade("São Paulo");
		endereco.setEstado("São Paulo");
		endereco.setEndereco("Rua Dez");
		endereco.setNumero("22");
		endereco.setReferencia("Bloco B");
		endereco.setLatitude("-23.5406338");
		endereco.setLongitude("-23.5406338");

//		diarista.endereco = endereco;

		IDiaristaTest diaristaTest = retrofit.create(IDiaristaTest.class);

		Call<Result<Diarista>> call = diaristaTest.create(diarista);
		Result<Diarista> response = call.execute().body();
		assertNotNull(response);
		assertEquals(response.getStatus(), 1);
		assertNotNull(response.getResult().getId());
	}

	public void FiltroAvancadoDiarista() throws IOException {

		List<Long> restricoes = new ArrayList<Long>();
		restricoes.add(7L);
		restricoes.add(4L);
		
		FiltroLocalizacao filtroLocalizacao = new FiltroLocalizacao();
		filtroLocalizacao.setLatitude("-23.60063");
		filtroLocalizacao.setLongitude("-46.557312");
		filtroLocalizacao.setValor(170);
		filtroLocalizacao.setRestricoesId(restricoes);
		filtroLocalizacao.setRaio(5);

		IDiaristaTest diaristaTest = retrofit.create(IDiaristaTest.class);

		Call<Result<Diarista>> call = diaristaTest.filterAvancado(filtroLocalizacao);
		Result<Diarista> response = call.execute().body();

		assertNotNull(response);
		assertEquals(response.getStatus(), 1);

	}

	
	public void filtraDiaristaPorLocalizacao() throws IOException {

		Endereco endereco = new Endereco();
		endereco.setLatitude("-23.5280038");
		endereco.setLongitude("-46.6939981");

		IDiaristaTest diaristaTest = retrofit.create(IDiaristaTest.class);

		Call<Result<Diarista>> call = diaristaTest.filterPorLocalizacao(endereco);
		Result<Diarista> response = call.execute().body();

		assertNotNull(response);
		assertEquals(response.getStatus(), 1);

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
