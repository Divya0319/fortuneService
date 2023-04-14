package com.fastturtle.fortuneService.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastturtle.fortuneService.entity.Fortunes;

import jakarta.persistence.EntityManager;

@Repository
public class FortuneDaoImpl implements FortuneDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public FortuneDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Integer save(Fortunes theFortune) {
		
		Session addFortuneSession = entityManager.unwrap(Session.class);
		
		return addFortuneSession.merge(theFortune).getId();
		
	}

	@Override
	public List<Fortunes> findAll() {
		Session getAllFortuneSession = entityManager.unwrap(Session.class);
		Query<Fortunes> theQuery = getAllFortuneSession.createQuery("from Fortunes", Fortunes.class);
		
		List<Fortunes> fortunes = theQuery.getResultList();
		return fortunes;
	}

}
