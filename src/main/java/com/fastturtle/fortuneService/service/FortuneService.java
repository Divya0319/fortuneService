package com.fastturtle.fortuneService.service;

import java.util.List;

import com.fastturtle.fortuneService.entity.Fortune;

public interface FortuneService {
	
	public void addFortune(Fortune theFortune);
	
	public List<Fortune> fetchAllFortunes();

}
