package com.fastturtle.fortuneService.dao;

import java.util.List;

import com.fastturtle.fortuneService.entity.Fortunes;

public interface FortuneDao {

	public void addFortune(Fortunes theFortune);
	
	public List<Fortunes> fetchAllFortunes();

}
