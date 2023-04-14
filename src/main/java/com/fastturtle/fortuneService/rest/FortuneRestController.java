package com.fastturtle.fortuneService.rest;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastturtle.fortuneService.entity.Fortunes;
import com.fastturtle.fortuneService.service.FortuneService;

@RestController
public class FortuneRestController {
	
	private FortuneService theFortuneService;
	private Random r;
	
	@Autowired
	public FortuneRestController(FortuneService theFortuneService) {
		this.theFortuneService = theFortuneService;
	}
	
	@PostMapping("/api/fortunes") 
	public Fortunes createNewFortune(@RequestBody Fortunes fortune){
		
		fortune.setId(0);
		theFortuneService.addFortune(fortune);
		return fortune;
	}
	
	@GetMapping("/api/fortunes") 
	public List<Fortunes> getAllFortunes(@RequestParam("random") Optional<Boolean> random) {
		List<Fortunes> fortunes = theFortuneService.fetchAllFortunes();
		
		if(fortunes.size() == 0) {
			Fortunes theFortune = new Fortunes(0, "No fortunes available");
			List<Fortunes> noFortunes = new ArrayList<>();
			noFortunes.add(theFortune);
			return noFortunes;
		} else {
			if(random.isPresent()) {
				r = new Random();
				Fortunes randomFortune = fortunes.get(r.nextInt(fortunes.size()));
				
				List<Fortunes> randomFortunes = new ArrayList<>();
				randomFortunes.add(randomFortune);
				return randomFortunes;
			}
		}
		
		
		
		return fortunes;
		
	}	

}
