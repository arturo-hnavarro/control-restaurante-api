package com.castrocarazo.restaurante.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ordenes")
public class OrdenDeComida implements Serializable {


	private static final long serialVersionUID = -4351419302771449310L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "create_at")
	private Date createAt;

	@OneToOne
	@JoinColumn(name = "mesa_id")
	private Mesa mesa;

	@Column(length = 60)
	private String cliente;
	
	private Double total;

	@OneToOne
	@JoinColumn(name = "estado_id")
	private EstadoOrden estadoOrden;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="orden_id") //creo la llave forania a la tabla orden_items
	private List<ItemOrden> items;

	
	@PrePersist
	public void prePersist() {
		createAt = new Date();// Agrega la fecha del momento a la creación
	}
	
	public OrdenDeComida() {
		this.items = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public EstadoOrden getEstadoOrden() {
		return estadoOrden;
	}

	public void setEstadoOrden(EstadoOrden estadoOrden) {
		this.estadoOrden = estadoOrden;
	}

	public List<ItemOrden> getItems() {
		return items;
	}

	public void setItems(List<ItemOrden> items) {
		this.items = items;
	}
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
