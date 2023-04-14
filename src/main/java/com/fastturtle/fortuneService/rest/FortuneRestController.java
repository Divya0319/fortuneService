package com.fastturtle.fortuneService.rest;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastturtle.fortuneService.entity.Fortunes;
import com.fastturtle.fortuneService.service.FortuneService;

@RestController
@RequestMapping("/api")
public class FortuneRestController {
	
	private FortuneService theFortuneService;
	private Random r;
	
	@Autowired
	public FortuneRestController(FortuneService theFortuneService) {
		this.theFortuneService = theFortuneService;
		r = new Random();
	}
	
	@PostMapping("/fortunes") 
	public Fortunes createNewFortune(@RequestBody Fortunes fortune){
		
		fortune.setId(0);
		int id = theFortuneService.save(fortune);
		fortune.setId(id);
		return fortune;
	}
	
	@GetMapping("/fortunes") 
	public List<Fortunes> getAllFortunes(@RequestParam("random") Optional<Boolean> random) {
		List<Fortunes> fortunes = theFortuneService.findAll();
		
		if(fortunes.size() == 0) {
			Fortunes theFortune = new Fortunes(0, "No fortunes available");
			List<Fortunes> noFortunes = new ArrayList<>();
			noFortunes.add(theFortune);
			return noFortunes;
		} else {
			if(random.isPresent() && random.get() == true) {
				Fortunes randomFortune = fortunes.get(r.nextInt(fortunes.size()));
				randomFortune.setId(null);
				
				List<Fortunes> randomFortunes = new ArrayList<>();
				randomFortunes.add(randomFortune);
				return randomFortunes;
			}
		}

		return fortunes;
		
	}	

}
