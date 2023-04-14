package com.fastturtle.fortuneService.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.fastturtle.fortuneService.entity.Fortune;

import jakarta.persistence.EntityManager;

public class FortuneDaoImpl implements FortuneDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public FortuneDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void addFortune(Fortune theFortune) {
		
		Session addFortuneSession = entityManager.unwrap(Session.class);
		
		addFortuneSession.merge(theFortune);
		
	}

	@Override
	public List<Fortune> fetchAllFortunes() {
		Session getAllFortuneSession = entityManager.unwrap(Session.class);
		Query<Fortune> theQuery = getAllFortuneSession.createQuery("from Fortune", Fortune.class);
		
		List<Fortune> fortunes = theQuery.getResultList();
		return fortunes;
	}

}
