package com.patrones.model;

public class SingletonUsuario {

	private String nombre;
	private String apellido;
	private Integer telefono;
	private Double tarifa;
	private static SingletonUsuario creado;

	public static SingletonUsuario getInstancia(String nombre, String apellido, Integer telefono, Double tarifa) {
		if (creado == null) {
			creado = new SingletonUsuario();
			creado.setNombre(nombre);
			creado.setApellido(apellido);
			creado.setTelefono(telefono);
			creado.setTarifa(tarifa);
		}
		else {
			System.out.println("Ya existe el singleton "+nombre);
		}
		return creado;
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
		return "Creado singleton con nombre: "+this.nombre+" y apellido: "+this.apellido+", teléfono: "+this.telefono.toString()
		+" y tarifa: "+this.tarifa.toString();
	}

}
