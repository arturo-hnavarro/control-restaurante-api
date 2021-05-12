package com.castrocarazo.restaurante.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orden_items")
public class ItemOrden implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int cantidad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="platillo_id")
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
		return cantidad * platillo.getPrecio();
	}
	
	public Platillo getPlatillo() {
		return platillo;
	}
	public void setPlatillo(Platillo platillo) {
		this.platillo = platillo;
	}

	private static final long serialVersionUID = -1629221507731907451L;
}
