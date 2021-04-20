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

import com.castrocarazo.restaurante.domain.CatalogoIngredientes;
import com.castrocarazo.restaurante.service.CatalogoIngredientesDaoService;

@RestController
@RequestMapping("/api/catalogo")
public class CatalogoIngredientesController {

	private static Logger log = LoggerFactory.getLogger(CatalogoIngredientesController.class);

	@Autowired
	CatalogoIngredientesDaoService catalogo;

	@GetMapping()
	public ResponseEntity<List<CatalogoIngredientes>> getAll() {
		log.info("CatalogoIngredientesController [getAll()] -> Intentando consultar la lista de catalogo");
		try {
			List<CatalogoIngredientes> respuesta = catalogo.findAll();
			if (respuesta != null)
				return new ResponseEntity<>(respuesta, HttpStatus.OK);
			else
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			log.error("Error al consultar la lista de catalogo. Exception" + ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<CatalogoIngredientes> guardar(@RequestBody CatalogoIngredientes catalogoIngredientes) {
		try {
			CatalogoIngredientes respuesta = catalogo.save(catalogoIngredientes);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<CatalogoIngredientes> editar(@RequestBody CatalogoIngredientes catalogoIngredientes) {
		try {
			CatalogoIngredientes respuesta = catalogo.save(catalogoIngredientes);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/ver")
	public ResponseEntity<CatalogoIngredientes> obtenerPorId(@RequestParam Long id) {
		try {
			CatalogoIngredientes catalogoIngredientes = catalogo.findById(id);
			if (catalogoIngredientes != null)
				return new ResponseEntity<>(catalogoIngredientes, HttpStatus.OK);
			else
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
