package com.castrocarazo.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castrocarazo.restaurante.dao.ICatalogoIngredientesDao;
import com.castrocarazo.restaurante.domain.CatalogoIngredientes;

@Service
public class CatalogoIngredientesDaoService {

	@Autowired
	ICatalogoIngredientesDao catalogo;

	public List<CatalogoIngredientes> findAll() {
		return (List<CatalogoIngredientes>) catalogo.findAll();
	}

	public CatalogoIngredientes save(CatalogoIngredientes ingredientes) {
		return catalogo.save(ingredientes);
	}

	public CatalogoIngredientes findById(Long id) {
		return catalogo.findById(id).orElse(null);
	}
}
