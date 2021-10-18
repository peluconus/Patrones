package com.patrones.model;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private Integer telefono;
	private Double tarifa;

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

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}
	
	public String toString() {
		return "Creado usuario con nombre: "+this.nombre+" y apellido: "+this.apellido+", teléfono: "+this.telefono.toString()
		+" y tarifa: "+this.tarifa.toString();
	}

}
