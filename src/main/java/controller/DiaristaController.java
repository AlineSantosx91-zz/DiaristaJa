package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiaristaController {
	
	@RequestMapping("/")
	public String home(){
		return "Teste diaristas!";
	}

}
