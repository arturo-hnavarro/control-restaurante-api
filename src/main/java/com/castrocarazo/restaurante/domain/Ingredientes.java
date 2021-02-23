package com.castrocarazo.restaurante.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "listado_ingredientes")
public class Ingredientes implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "catalogo_id")
	private CatalogoIngredientes detalleIngrediente;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CatalogoIngredientes getDetalleIngrediente() {
		return detalleIngrediente;
	}

	public void setDetalleIngrediente(CatalogoIngredientes detalleIngrediente) {
		this.detalleIngrediente = detalleIngrediente;
	}

	private static final long serialVersionUID = 3384872708970554392L;

}
