package com.castrocarazo.restaurante.dao;

import org.springframework.data.repository.CrudRepository;

import com.castrocarazo.restaurante.domain.Ingredientes;

public interface IIngredientesDao extends CrudRepository<Ingredientes, Long> {

}
