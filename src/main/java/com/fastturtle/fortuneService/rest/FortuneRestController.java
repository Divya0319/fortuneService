package com.fastturtle.fortuneService.rest;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastturtle.fortuneService.entity.Fortune;
import com.fastturtle.fortuneService.service.FortuneService;

@RestController
public class FortuneRestController {
	
	private FortuneService theFortuneService;
	private Random r;
	
	@Autowired
	public FortuneRestController(FortuneService theFortuneService) {
		this.theFortuneService = theFortuneService;
		r = new Random();
	}
	
	@PostMapping("/api/fortunes") 
	public Fortune createNewFortune(@RequestBody Fortune fortune){
		
		fortune.setId(0);
		theFortuneService.addFortune(fortune);
		return fortune;
	}
	
	@GetMapping("/api/fortunes") 
	public List<Fortune> getAllFortunes() {
		List<Fortune> fortunes = theFortuneService.fetchAllFortunes();
		
		if(fortunes.size() == 0) {
			Fortune theFortune = new Fortune(0, "No fortunes available");
			List<Fortune> noFortunes = new ArrayList<>();
			noFortunes.add(theFortune);
			return noFortunes;
		}
		
		return fortunes;
		
	}
	
	@GetMapping("/api/fortunes") 
	public Fortune getRandomFortunes(@RequestParam("random") boolean random) {
		List<Fortune> fortunes = theFortuneService.fetchAllFortunes();
		
		if(fortunes.size() == 0) {
			return new Fortune(0, "No fortunes available");
		}
		
		Fortune randomFortune = fortunes.get(r.nextInt());
		
		return randomFortune;
		
	}

}
