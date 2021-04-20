package com.castrocarazo.restaurante.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.castrocarazo.restaurante.domain.OrdenDeComida;
import com.castrocarazo.restaurante.service.OrdenesDaoService;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenesController {

	@Autowired
	OrdenesDaoService ordenesService;

	@GetMapping()
	public ResponseEntity<List<OrdenDeComida>> getAll() {
		try {
			List<OrdenDeComida> ordenes = (List<OrdenDeComida>) ordenesService.findAll();
			return new ResponseEntity<>(ordenes, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("/ver")
	public ResponseEntity<OrdenDeComida> get(@RequestParam Long id) {
		try {
			OrdenDeComida orden = ordenesService.findById(id);
			if (orden != null) {
				return new ResponseEntity<>(orden, HttpStatus.FOUND);
			} else
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	@PostMapping("/salvar")
	public ResponseEntity<OrdenDeComida> salvar(@RequestBody OrdenDeComida orden) {
		try {
			OrdenDeComida response = ordenesService.save(orden);
			if (response != null) {
				return new ResponseEntity<>(response, HttpStatus.CREATED);
			} else
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> eliminar(@RequestParam Long id) {
		try {
			ordenesService.deleteById(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("editar_por_id")
	public ResponseEntity<OrdenDeComida> editarPorId(@RequestParam Long id, @RequestParam Long estadoId) {
		try {
			OrdenDeComida respuesta = ordenesService.editarEstadoPorId(id, estadoId);
			if(respuesta!= null)
				return new ResponseEntity<>(respuesta, HttpStatus.OK);
			else
				return new ResponseEntity<>(respuesta, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
