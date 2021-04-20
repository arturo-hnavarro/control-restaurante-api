package com.castrocarazo.restaurante.dao;

import org.springframework.data.repository.CrudRepository;

import com.castrocarazo.restaurante.domain.CatalogoIngredientes;

public interface ICatalogoIngredientesDao extends CrudRepository<CatalogoIngredientes, Long>{

}
