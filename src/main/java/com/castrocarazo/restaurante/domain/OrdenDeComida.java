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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ordenes")
public class OrdenDeComida implements Serializable {

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
	private double total;

	@OneToOne
	@JoinColumn(name = "estado_id")
	private EstadoPlatillo estadoPlatillo;


	//Una orden muchos items
	/*@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL) //Registro primero la orden y luego los insert. Al eliminar primero las lineas y luego los items
	@JoinColumn(name="orden_id") //indico el FK. Crea un campo FK en la tabla facturas_items
	private List<Items> items;*/
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name="platillos_orden", joinColumns =  @JoinColumn(name="orden_id"),///foreing keys para las tablas 
	inverseJoinColumns = @JoinColumn(name="platillo_id"),//foreing keys para las tablas
	uniqueConstraints = {@UniqueConstraint(columnNames = {"orden_id", "platillo_id"})})// configurar para no repetir 
	private List<Platillo> platillos;


	@PrePersist
	public void prePersist() {
		createAt = new Date();// Agrega la fecha del momento a la creación
	}
	
	public OrdenDeComida() {
		this.platillos = new ArrayList<>();
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public EstadoPlatillo getEstadoPlatillo() {
		return estadoPlatillo;
	}

	public void setEstadoPlatillo(EstadoPlatillo estadoPlatillo) {
		this.estadoPlatillo = estadoPlatillo;
	}

	public List<Platillo> getPlatillos() {
		return platillos;
	}

	public void setPlatillo(List<Platillo> platillos) {
		this.platillos = platillos;
	}

	private static final long serialVersionUID = -3206903864858417920L;
}
