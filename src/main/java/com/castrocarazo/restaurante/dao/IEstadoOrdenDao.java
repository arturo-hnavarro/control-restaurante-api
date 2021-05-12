package com.castrocarazo.restaurante.dao;

import org.springframework.data.repository.CrudRepository;

import com.castrocarazo.restaurante.domain.EstadoOrden;

public interface IEstadoOrdenDao extends CrudRepository<EstadoOrden, Long>{

}
