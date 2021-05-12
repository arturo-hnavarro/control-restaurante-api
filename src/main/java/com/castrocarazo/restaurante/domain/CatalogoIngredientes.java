package com.castrocarazo.restaurante.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catalogo_ingredientes")
public class CatalogoIngredientes implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 50)
	private String nombre;
	
	@Column(name= "cantidad_disponible")
	private Integer candidadDisponible;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setUsername(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCandidadDisponible() {
		return candidadDisponible;
	}

	public void setCandidadDisponible(Integer candidadDisponible) {
		this.candidadDisponible = candidadDisponible;
	}

	private static final long serialVersionUID = -7521265928697677803L;

}
