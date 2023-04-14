package com.fastturtle.fortuneService.service;

import java.util.List;

import com.fastturtle.fortuneService.entity.Fortunes;

public interface FortuneService {
	
	public Integer save(Fortunes theFortune);
	
	public List<Fortunes> findAll();

}
