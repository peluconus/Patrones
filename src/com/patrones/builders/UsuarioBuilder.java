package com.patrones.builders;

import com.patrones.model.Usuario;

public class UsuarioBuilder {
	
	public Usuario build(String nombre, String apellido, Integer telefono) {
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setTelefono(telefono);
		usuario.setTarifa(5.09);
		
		return usuario;
	}

}
