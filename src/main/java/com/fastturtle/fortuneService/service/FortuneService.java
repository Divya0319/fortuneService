package com.fastturtle.fortuneService.service;

import java.util.List;

import com.fastturtle.fortuneService.entity.Fortunes;

public interface FortuneService {
	
	public void addFortune(Fortunes theFortune);
	
	public List<Fortunes> fetchAllFortunes();

}
