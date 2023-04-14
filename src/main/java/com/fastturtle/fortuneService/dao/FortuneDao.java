package com.fastturtle.fortuneService.dao;

import java.util.List;

import com.fastturtle.fortuneService.entity.Fortune;

public interface FortuneDao {

	public void addFortune(Fortune theFortune);
	
	public List<Fortune> fetchAllFortunes();

}
