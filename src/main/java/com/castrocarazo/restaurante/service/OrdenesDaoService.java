package com.castrocarazo.restaurante.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castrocarazo.restaurante.dao.ICatalogoIngredientesDao;
import com.castrocarazo.restaurante.dao.IOrdenDao;
import com.castrocarazo.restaurante.domain.CatalogoIngredientes;
import com.castrocarazo.restaurante.domain.EstadoPlatillo;
import com.castrocarazo.restaurante.domain.ItemOrden;
import com.castrocarazo.restaurante.domain.OrdenDeComida;


@Service
public class OrdenesDaoService {

	@Autowired
	IOrdenDao ordenesService;
	@Autowired
	ICatalogoIngredientesDao inventario;
	
	@Autowired
	MenuDaoService productos;

	public List<OrdenDeComida> findAll() {
		return (List<OrdenDeComida>) ordenesService.findAll();
	}

	public OrdenDeComida findById(Long id) {
		return ordenesService.findById(id).orElse(null);
	}

	public OrdenDeComida save(OrdenDeComida orden) {
		OrdenDeComida response = null;
		if (orden.getId() == null)
			orden.setEstadoPlatillo(
					new EstadoPlatillo(Long.valueOf(3), "solicitada", "Solicitada la orden por el cliente."));

		for (ItemOrden item : orden.getItems()) {
			actualizarCantidadEnInventario(item.getPlatillo().getIngredientes());// Actualizo el disponible en el inventario(catalogo)
		}

		response = ordenesService.save(orden);
		
		return response;
	}

	public void deleteById(Long id) {
		ordenesService.deleteById(id);
	}

	// Utilitarios
	private void actualizarCantidadEnInventario(List<CatalogoIngredientes> ingredientes) {
		for (CatalogoIngredientes catalogoIngredientes : ingredientes) {
			actualizarCantidadEnInventario(catalogoIngredientes.getId(), catalogoIngredientes.getCandidadDisponible());
		}
	}

	private void actualizarCantidadEnInventario(Long id, int cantidadSolicitada) {
		CatalogoIngredientes item = inventario.findById(id).orElse(null);
		if (item != null) {
			item.setCandidadDisponible(item.getCandidadDisponible() - cantidadSolicitada);
			inventario.save(item);
		}
	}
	
	
}
