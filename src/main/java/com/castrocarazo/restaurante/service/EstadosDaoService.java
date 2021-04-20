package com.castrocarazo.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castrocarazo.restaurante.dao.IEstadoPlatilloDao;
import com.castrocarazo.restaurante.domain.EstadoPlatillo;

@Service
public class EstadosDaoService {

	@Autowired
	IEstadoPlatilloDao estadosPlatillos;

	public List<EstadoPlatillo> findAll() {
		return (List<EstadoPlatillo>) estadosPlatillos.findAll();
	}

	public EstadoPlatillo save(EstadoPlatillo estado) {
		return estadosPlatillos.save(estado);
	}

	public EstadoPlatillo findById(Long id) {
		return estadosPlatillos.findById(id).orElse(null);
	}
}
