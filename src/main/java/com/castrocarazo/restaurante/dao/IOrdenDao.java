package com.castrocarazo.restaurante.dao;

import org.springframework.data.repository.CrudRepository;

import com.castrocarazo.restaurante.domain.OrdenDeComida;

public interface IOrdenDao extends CrudRepository<OrdenDeComida, Long> {

}
