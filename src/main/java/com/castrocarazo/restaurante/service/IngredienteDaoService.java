package com.castrocarazo.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castrocarazo.restaurante.dao.IIngredientesDao;
import com.castrocarazo.restaurante.domain.Ingredientes;

@Service
public class IngredienteDaoService {

	@Autowired
	IIngredientesDao ingredientesDao;

	public List<Ingredientes> findAll() {
		return (List<Ingredientes>) ingredientesDao.findAll();
	}

	public Ingredientes save(Ingredientes ingredientes) {
		return ingredientesDao.save(ingredientes);
	}

	public Ingredientes findById(Long id) {
		return ingredientesDao.findById(id).orElse(null);
	}
}