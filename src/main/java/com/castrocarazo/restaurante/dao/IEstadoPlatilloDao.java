package com.castrocarazo.restaurante.dao;

import org.springframework.data.repository.CrudRepository;

import com.castrocarazo.restaurante.domain.EstadoPlatillo;

public interface IEstadoPlatilloDao extends CrudRepository<EstadoPlatillo, Long> {

}
