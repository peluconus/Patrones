package com.patrones.model;

public class PersonaTarifa1 extends Persona {

	public PersonaTarifa1(String nombre, String apellido, Integer telefono, Double tarifa) {
		super(nombre, apellido, telefono, tarifa);
	}
	
	public PersonaTarifa1 clone() {
		return new PersonaTarifa1(this.getNombre(), this.getApellido(), this.getTelefono(), this.getTarifa());
	}
	
	public String toString() {
		return "Creado usuario con tarifa: "+this.tarifa.toString();
	}



}
