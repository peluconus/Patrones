package com.patrones;

import com.patrones.builders.UsuarioBuilder;
import com.patrones.model.Usuario;

public class UsuarioApplication {

	public static void main(String[] args) {
		Usuario usuario = new UsuarioBuilder().build("Ejemplo", "Ejemplez", 987908712);
		System.out.println(usuario.toString());

	}

}
