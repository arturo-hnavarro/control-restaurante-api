package com.castrocarazo.restaurante.domain;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 20)
	private String username;

	@Column(length = 60)
	private String password;
	private Boolean enabled;
	private String nombre;
	private String apellido;

	@Column(unique = true, length = 100)
	private String email;

	// un usuario muchos roles @ManyToMany por debajo crea una tabla intermedia usuarios_roles
	//FetchType.LAZY carga solo cuando se hace llamado al metodo getRoles. Esto evita que se sobre cargue la bd si la llamada no es necesaria
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="usuarios_roles", joinColumns =  @JoinColumn(name="usuario_id"),//foreing keys para las tablas 
	inverseJoinColumns = @JoinColumn(name="role_id"),//foreing keys para las tablas
	uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})})// configurar para que los usuarios no tengan roles repetidos 
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	private static final long serialVersionUID = -7027534110386680473L;

}
