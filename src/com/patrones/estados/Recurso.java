package com.patrones.estados;

public class Recurso {

	private String nombre;
	private Integer valor;
	private Estados estado;

	public Recurso() {
	}

	public Recurso(String nombre, Integer valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.estado = Estados.OPEN;
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

}
