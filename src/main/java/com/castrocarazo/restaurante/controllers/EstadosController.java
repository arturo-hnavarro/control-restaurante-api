package com.castrocarazo.restaurante.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.castrocarazo.restaurante.domain.EstadoOrden;
import com.castrocarazo.restaurante.domain.EstadoPlatillo;
import com.castrocarazo.restaurante.service.EstadoOrdenDaoService;
import com.castrocarazo.restaurante.service.EstadosDaoService;


@RestController
@RequestMapping("/api/estados")
public class EstadosController {

	private static Logger log = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	EstadosDaoService estados;
	@Autowired
	EstadoOrdenDaoService estadosOrdenes;
	

	@GetMapping("platillos")
	public ResponseEntity<List<EstadoPlatillo>> getAll() {
		log.info("EstadosController [getAll()] -> Intentando consultar la lista de estados");
		try {
			List<EstadoPlatillo> estadosResponse = estados.findAll();
			if (estadosResponse != null)
				return new ResponseEntity<>(estadosResponse, HttpStatus.OK);
			else
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			log.error("Error al consultar la lista de estados. Exception" + ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "platillos", consumes = "application/json")
	public ResponseEntity<EstadoPlatillo> guardar(@RequestBody EstadoPlatillo estadoPlatillo) {
		try {
			EstadoPlatillo respuesta = estados.save(estadoPlatillo);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "platillos", consumes = "application/json")
	public ResponseEntity<EstadoPlatillo> editar(@RequestBody EstadoPlatillo estadoPlatillo) {
		try {
			EstadoPlatillo respuesta = estados.save(estadoPlatillo);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("platillos/ver")
	public ResponseEntity<EstadoPlatillo> obtenerPorId(@RequestParam Long id) {
		try {
			EstadoPlatillo estadoPlatillo = estados.findById(id);
			if (estadoPlatillo != null)
				return new ResponseEntity<>(estadoPlatillo, HttpStatus.OK);
			else
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//*---------------
	@GetMapping("ordenes")
	public ResponseEntity<List<EstadoOrden>> getAllEstadosOrdenes() {
		log.info("EstadosController [getAll()] -> Intentando consultar la lista de estadosOrdenes");
		try {
			List<EstadoOrden> estadosOrdenesResponse = estadosOrdenes.findAll();
			if (estadosOrdenesResponse != null)
				return new ResponseEntity<>(estadosOrdenesResponse, HttpStatus.OK);
			else
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			log.error("Error al consultar la lista de estadosOrdenes. Exception" + ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "ordenes", consumes = "application/json")
	public ResponseEntity<EstadoOrden> guardarEstadosOrdenes(@RequestBody EstadoOrden estadoPlatillo) {
		try {
			EstadoOrden respuesta = estadosOrdenes.save(estadoPlatillo);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "ordenes", consumes = "application/json")
	public ResponseEntity<EstadoOrden> editar(@RequestBody EstadoOrden estadoPlatillo) {
		try {
			EstadoOrden respuesta = estadosOrdenes.save(estadoPlatillo);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("ordenes/ver")
	public ResponseEntity<EstadoOrden> obtenerEstadosOrdenPorId(@RequestParam Long id) {
		try {
			EstadoOrden estadoPlatillo = estadosOrdenes.findById(id);
			if (estadoPlatillo != null)
				return new ResponseEntity<>(estadoPlatillo, HttpStatus.OK);
			else
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
