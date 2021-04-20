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
import com.castrocarazo.restaurante.domain.Platillo;

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

	/*
	 * Metodo encargado de almacenar una orden en BD y disminuir la cantidad disponible en el inventario
	 */
	public OrdenDeComida save(OrdenDeComida orden) {
		OrdenDeComida response = null;
		if (orden.getId() == null)
			orden.setEstadoPlatillo(
					new EstadoPlatillo(Long.valueOf(3), "solicitada", "Solicitada la orden por el cliente."));
		response = ordenesService.save(orden);
		actualizarInventario(orden.getItems());
		return response;
	}

	public void deleteById(Long id) {
		ordenesService.deleteById(id);
	}

	
	/**
	 * Actualiza el disponible en el inventario de CatalogoIngredientes
	 * @param items
	 */
	private void actualizarInventario(List<ItemOrden> items) {
		for (ItemOrden item : items) {
			Platillo platillo = productos.findById(item.getPlatillo().getId());

			for (CatalogoIngredientes itemCatalogo : platillo.getIngredientes()) {
				CatalogoIngredientes ingrediente = inventario.findById(itemCatalogo.getId()).orElse(null);
				if (ingrediente != null) {
					ingrediente.setCandidadDisponible(ingrediente.getCandidadDisponible() - item.getCantidad());
					inventario.save(ingrediente);
				}
			}
		}
	}
}