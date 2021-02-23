package com.castrocarazo.restaurante.dao;

import org.springframework.data.repository.CrudRepository;

import com.castrocarazo.restaurante.domain.Platillo;

public interface IMenuDao extends CrudRepository<Platillo, Long> {

}
