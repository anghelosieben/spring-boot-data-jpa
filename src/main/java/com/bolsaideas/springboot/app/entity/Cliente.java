package com.bolsaideas.springboot.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//@Column(name="nombre_cliente",unique, length)
	@NotBlank
	@Size(min = 4)
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	@Email
	private String email;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")//solo en date picker html type="date"   *en tema validaciones*
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)//formato en el cual se guardara DATE,TIMESTAMP
	private Date createAt; // --->> solo acepta 09/02/2017
	/*@PrePersist
	public void prePersist() {
		createAt=new Date();
	}*/
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
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", createAt=" + createAt + "]";
	}
	
}
