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
@Table(name = "articulos_orden_comida")
public class Items implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int cantidad;
	private double precio;
	
	@OneToOne
	@JoinColumn(name = "platillo_id")
	private Platillo platillo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Platillo getPlatillo() {
		return platillo;
	}
	public void setPlatillo(Platillo platillo) {
		this.platillo = platillo;
	}

	private static final long serialVersionUID = -1629221507731907451L;
}
