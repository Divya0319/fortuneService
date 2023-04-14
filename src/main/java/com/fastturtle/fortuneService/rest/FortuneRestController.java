package com.fastturtle.fortuneService.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastturtle.fortuneService.entity.Fortune;

@RestController
public class FortuneRestController {
	
	@PostMapping("/api/fortunes") 
	public Fortune createNewFortune(@RequestBody Fortune fortune){
		
	}
	
	@GetMapping("/api/fortunes") 
	public List<Fortune> getAllFortunes() {
		
	}

}
