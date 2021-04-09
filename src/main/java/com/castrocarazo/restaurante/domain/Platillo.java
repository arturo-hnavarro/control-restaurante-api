package com.castrocarazo.restaurante.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "platillos")
public class Platillo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 150)
	private String nombre;

	private Double precio;

	@Temporal(TemporalType.DATE)
	@Column(name = "create_at")
	private Date createAt;


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="platillos_ingredientes", joinColumns =  @JoinColumn(name="platillo_id"),//foreing keys para las tablas 
	inverseJoinColumns = @JoinColumn(name="ingrediente_id"),//foreing keys para las tablas
	uniqueConstraints = {@UniqueConstraint(columnNames = {"platillo_id", "ingrediente_id"})})// configurar para no repetir 
	private List<CatalogoIngredientes> ingredientes;

	@OneToOne
	@JoinColumn(name = "estado_id")
	private EstadoPlatillo estadoPlatillo;

	@OneToOne
	@JoinColumn(name = "tipo_id")
	private TipoPlato tipoPlato;
	
	private String image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public List<CatalogoIngredientes> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<CatalogoIngredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public EstadoPlatillo getEstadoPlatillo() {
		return estadoPlatillo;
	}
	
	public void setEstadoPlatillo(EstadoPlatillo estadoPlatillo) {
		this.estadoPlatillo = estadoPlatillo;
	}

	public TipoPlato getTipoPlato() {
		return tipoPlato;
	}

	public void setTipoPlato(TipoPlato tipoPlato) {
		this.tipoPlato = tipoPlato;
	}
	
	public String getImage() {
		return image;
	}

	public void setImgage(String image) {
		this.image = image;
	}
	
	private static final long serialVersionUID = 7138317283952280030L;

}
