package com.castrocarazo.restaurante.dao;

import org.springframework.data.repository.CrudRepository;

import com.castrocarazo.restaurante.domain.TipoPlato;

public interface ITipoPlato  extends CrudRepository<TipoPlato, Long>{

}
