package com.patrones.estados;

public class Recurso {

	private String nombre;
	private Integer valor;
	private Estados estado;

	public Recurso() {
	}

	public Recurso(String nombre, Integer valor, Estados estado) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.estado = estado;
	}
	
	public Recurso clone() {
		return new Recurso(this.nombre, this.valor, this.estado);
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	
	public String toString() {
		return "El "+this.nombre+" con valor "+this.valor+" tiene el estado: "+this.estado;
	}

}
