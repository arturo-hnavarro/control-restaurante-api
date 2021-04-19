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

import com.castrocarazo.restaurante.dao.MenuDaoService;
import com.castrocarazo.restaurante.domain.Platillo;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

	private static Logger log = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	MenuDaoService menu;

	@GetMapping()
	public ResponseEntity<List<Platillo>> getAll() {
		log.info("MenuController [getAll()] -> Intentando consultar la lista de platillos");
		try {
			List<Platillo> platillos = menu.findAll();
			if(platillos != null)
				return new ResponseEntity<>(platillos, HttpStatus.OK);
			else 
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			log.error("Error al consultar la lista de platillos. Exception" + ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<Platillo> guardar(@RequestBody Platillo platillo) {
		try {
			Platillo respuesta = menu.save(platillo);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<Platillo> editar(@RequestBody Platillo platillo) {
		try {
			Platillo respuesta = menu.save(platillo);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/ver")
	public ResponseEntity<Platillo> obtenerPorId(@RequestParam Long id) {
		try {
			Platillo platillo = menu.findById(id);
			if(platillo != null) 
				return new ResponseEntity<>(platillo, HttpStatus.OK);
			else
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
