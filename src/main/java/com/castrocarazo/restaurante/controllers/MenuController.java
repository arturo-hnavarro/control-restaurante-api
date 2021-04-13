package com.castrocarazo.restaurante.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.castrocarazo.restaurante.dao.IMenuDao;
import com.castrocarazo.restaurante.domain.Platillo;


@RestController
@RequestMapping("/api/menu")
public class MenuController {
	
	@Autowired
	IMenuDao menu;
	
	@GetMapping()
	public ResponseEntity<List<Platillo>> getAll(){
		try{
			List<Platillo> platillos = (List<Platillo>) menu.findAll();
			return new ResponseEntity<>(platillos, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Platillo> guardar(@RequestBody Platillo platillo){
		try{
			Platillo respuesta  = menu.save(platillo);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/ver")
	public ResponseEntity<Platillo> obtenerPorId(@RequestParam Long id){
		try{
			Platillo platillo  = menu.findById(id).orElse(null);
			return new ResponseEntity<>(platillo, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
