package com.fastturtle.fortuneService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastturtle.fortuneService.dao.FortuneDao;
import com.fastturtle.fortuneService.entity.Fortunes;

@Service
public class FortuneServiceImpl implements FortuneService{
	
	private FortuneDao fortuneDao;
	
	@Autowired
	public FortuneServiceImpl(FortuneDao fortuneDao) {
		this.fortuneDao = fortuneDao;
	}

	@Override
	@Transactional
	public Integer save(Fortunes theFortune) {
		
		return fortuneDao.save(theFortune);
	}

	@Override
	@Transactional
	public List<Fortunes> findAll() {
		
		return fortuneDao.findAll();
	}

}
