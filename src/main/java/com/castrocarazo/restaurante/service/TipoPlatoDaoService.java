package com.castrocarazo.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castrocarazo.restaurante.dao.ITipoPlato;
import com.castrocarazo.restaurante.domain.TipoPlato;

@Service
public class TipoPlatoDaoService {

	@Autowired
	ITipoPlato tipoPlatos;

	public List<TipoPlato> findAll() {
		return (List<TipoPlato>) tipoPlatos.findAll();
	}

	public TipoPlato save(TipoPlato estado) {
		return tipoPlatos.save(estado);
	}

	public TipoPlato findById(Long id) {
		return tipoPlatos.findById(id).orElse(null);
	}
}
