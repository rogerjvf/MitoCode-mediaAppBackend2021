package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Informacion del Paciente")
@Entity
@Table(name = "paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@ApiModelProperty(notes="Nombres debe tener un minimo de 3 caracteres")
	@Size(min =3, message="Nombres debe tener un minimo de 3 caracteres")
	@Column(name = "nombres", nullable=false, length=70)
	@NotBlank
	private String nombres;
	
	@ApiModelProperty(notes="Apellidos debe tener un minimo de 3 caracteres")
	@Size(min =3,max=70, message="Apellidos debe tener un minimo de 3 caracteres")
	@Column(name = "apellidos", nullable=false, length=70)
	private String apellidos;
	
	@ApiModelProperty(notes="DNI debe tener maximo de  8 caracteres")
	@Size(min =8,max=8, message="DNI debe tener maximo de  8 caracteres")
	@Column(name = "dni", nullable=false, length=8)
	private String dni ;
	
	@ApiModelProperty(notes="Edad no puede ser mayor a 60 anos de edad")
	@Column(name = "edad", nullable=true, length=2)
	@Max(value =60, message="Edad no puede ser mayor a 60 anos de edad")
	@Min(value=5, message="Edad debe ser mayor a 5 anos")
	private Integer edad;
	
	@ApiModelProperty(notes="Direccion debe tener maximo de 150 caracteres")
	@Size(max =150, message="Direccion debe tener maximo de 150 caracteres")
	@Column(name = "direccion", nullable=true, length=150)
	private String direccion; 
	
	@ApiModelProperty(notes="Telefono debe tener maximo de 9 caracteres")
	@Size(min =9,max =9, message="Telefono debe tener maximo de 9 caracteres")
	@Column(name = "telefono", nullable=true, length=9)
	private String telefono;
	
	@ApiModelProperty(notes="Debe ingresar una direccion de correo ")
	@Email 
	@Column(name = "email", nullable=true, length=55)
	private String email;
	
	
	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
	

}
