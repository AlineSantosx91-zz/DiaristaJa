package br.com.diaristaja.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.service.DiaristaService;
import br.com.diaristaja.validators.Result;

@RunWith(MockitoJUnitRunner.class)
public class DiaristaControllerTest {
	
	@InjectMocks
	private DiaristaController diaristaController;
	
	@Mock
	private DiaristaService diaristaService;
	
	Result<Diarista> diarista;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp(){
		this.diarista = mock(Result.class);
	}
		
	
	@SuppressWarnings("unchecked")
	@Test
	public void findAllTest(){
		//given
		Result<Diarista>  diaristaList = mock(Result.class);
		
		//when
		when(diaristaService.findAll()).thenReturn(diaristaList);
		
		//then
		Result<Diarista> response = diaristaController.findAll();
		assertNotNull(response);
	}
	
	@Test
	public void createTest(){
	
		//when
		when(diaristaService.save(any(Diarista.class))).thenReturn(diarista);

		//then
		Result<Diarista> response = diaristaController.create(any(Diarista.class));
		assertNotNull(response);
	}
	
	@Test
	public void findByIdTest(){

		//when
		when(diaristaService.findOne(anyLong())).thenReturn(diarista);
		
		//then
		Result<Diarista> response = diaristaController.findById(anyLong());
		assertNotNull(response);
	}
	
	@Test
	public void updateTest(){
		
		//given
		Diarista diaristaMock = mock(Diarista.class);
		
		//when
		when(diaristaService.update(any(Diarista.class), anyLong())).thenReturn(diarista);
		
		//then
		Result<Diarista> response = diaristaController.update(any(Long.class), eq(diaristaMock));
		assertNotNull(response);
	}

}
