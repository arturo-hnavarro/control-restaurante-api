package com.castrocarazo.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castrocarazo.restaurante.dao.IEstadoOrdenDao;
import com.castrocarazo.restaurante.domain.EstadoOrden;

@Service
public class EstadoOrdenDaoService {

	@Autowired
	IEstadoOrdenDao estadosOrdenes;
	
	public List<EstadoOrden> findAll() {
		return (List<EstadoOrden>) estadosOrdenes.findAll();
	}

	public EstadoOrden save(EstadoOrden estado) {
		return estadosOrdenes.save(estado);
	}

	public EstadoOrden findById(Long id) {
		return estadosOrdenes.findById(id).orElse(null);
	}
}
