package com.fastturtle.fortuneService.dao;

import java.util.List;

import com.fastturtle.fortuneService.entity.Fortunes;

public interface FortuneDao {

	public Integer save(Fortunes theFortune);
	
	public List<Fortunes> findAll();

}
