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

import com.castrocarazo.restaurante.domain.TipoPlato;
import com.castrocarazo.restaurante.service.TipoPlatoDaoService;

@RestController
@RequestMapping("/api/tipo-plato")
public class TipoPlatoController {
	
	private static Logger log = LoggerFactory.getLogger(TipoPlatoController.class);

	@Autowired
	TipoPlatoDaoService platos;

	@GetMapping()
	public ResponseEntity<List<TipoPlato>> getAll() {
		log.info("EstadosController [getAll()] -> Intentando consultar la lista de estados");
		try {
			List<TipoPlato> response = platos.findAll();
			if (response != null)
				return new ResponseEntity<>(response, HttpStatus.OK);
			else
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			log.error("Error al consultar la lista de estados. Exception" + ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<TipoPlato> guardar(@RequestBody TipoPlato tipoPlatillo) {
		try {
			TipoPlato respuesta = platos.save(tipoPlatillo);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<TipoPlato> editar(@RequestBody TipoPlato tipoPlatillo) {
		try {
			TipoPlato respuesta = platos.save(tipoPlatillo);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/ver")
	public ResponseEntity<TipoPlato> obtenerPorId(@RequestParam Long id) {
		try {
			TipoPlato tipoPlatillo = platos.findById(id);
			if (tipoPlatillo != null)
				return new ResponseEntity<>(tipoPlatillo, HttpStatus.OK);
			else
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
