package br.com.diaristaja.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.service.DiaristaService;
import retrofit2.Callback;

@RunWith(MockitoJUnitRunner.class)
public class DiaristaControllerTest {
	
	@InjectMocks
	private DiaristaController diaristaController;
	
	@Mock
	private DiaristaService diaristaService;
	
	Diarista diarista;
	
	@Before
	public void setUp(){
		this.diarista = mock(Diarista.class);
	}
		
	
	@SuppressWarnings("unchecked")
	@Test
	public void findAllTest(){
		//given
		List<Diarista> diaristaList = mock(List.class);
		
		//when
		when(diaristaService.findAll()).thenReturn(diaristaList);
		
		//then
		List<Diarista> response = diaristaController.findAll();
		assertNotNull(response);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void createTest(){
	
		//when
		when(diaristaService.save(any(Diarista.class))).thenReturn(diarista);

		//then
		Diarista response = diaristaController.create(any(Diarista.class));
		assertNotNull(response);
	}
	
	@Test
	public void findByIdTest(){

		//when
		when(diaristaService.findOne(anyLong())).thenReturn(diarista);
		
		//then
		Diarista response = diaristaController.findById(anyLong());
		assertNotNull(response);
	}
	
	@Test
	public void updateTest(){
		
		//when
		when(diaristaService.findOne(anyLong())).thenReturn(diarista);
		when(diaristaService.save(any(Diarista.class))).thenReturn(diarista);
		
		//then
		Diarista response = diaristaController.update(any(Long.class), diarista);
		assertNotNull(response);
	}

}
