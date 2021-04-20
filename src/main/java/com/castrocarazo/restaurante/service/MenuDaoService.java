package com.castrocarazo.restaurante.service;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castrocarazo.restaurante.dao.IMenuDao;
import com.castrocarazo.restaurante.domain.Platillo;

@Service
public class MenuDaoService {

	private static Logger log = LoggerFactory.getLogger(MenuDaoService.class);

	@Autowired
	IMenuDao menu;

	public List<Platillo> findAll() {
		return asignarImgABytes((List<Platillo>) menu.findAll());
	}

	public Platillo save(Platillo platillo) {
		return menu.save(platillo);
	}

	public Platillo findById(Long id) {
		Platillo platillo = menu.findById(id).orElse(null);
		if(platillo != null)
			platillo.setImageInBytes(transformarImgABytes(platillo.getImage()));
		return platillo;
	}
	
	public void deleteById(Long id) {
		menu.deleteById(id);
	}
	
	
	private List<Platillo> asignarImgABytes(List<Platillo> lista) {
		try {
			for (Platillo platillo : lista) {
				platillo.setImageInBytes(transformarImgABytes(platillo.getImage()));
			}
		} catch (Exception ignore) {
			log.error("Error al convertir imagen a bytes. Exception" + ignore.toString());
		}
		return lista;
	}

	private byte[] transformarImgABytes(String ubicacion) {
		try {
			File fi = new File(ubicacion);
			byte[] fileContent = Files.readAllBytes(fi.toPath());
			return fileContent;
		} catch (Exception ignore) {
			log.error("Error al convertir imagen a bytes. Exception" + ignore.toString());
		}
		return null;
	}
	
	
}
