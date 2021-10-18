package com.patrones;

import com.patrones.builders.UsuarioBuilder;
import com.patrones.model.PersonaTarifa1;
import com.patrones.model.SingletonUsuario;
import com.patrones.model.Usuario;

public class UsuarioApplication {

	public static void main(String[] args) {

		// Práctica Builder
		Usuario usuario = new UsuarioBuilder().build("Ejemplo", "Ejemplez", 987908712);
		System.out.println(usuario.toString());

		// Práctica Singleton
		new SingletonUsuario();
		SingletonUsuario singleton = SingletonUsuario.getInstancia("Single", "Ton", 23454321, 3.14);
		System.out.println(singleton.toString());

		// Práctica Prototype
		PersonaTarifa1 persona = new PersonaTarifa1("Proto", "Type", 123, 1.0);
		PersonaTarifa1[] lista = new PersonaTarifa1[5];
		for (int i = 0; i<5; i++) {
			PersonaTarifa1 clon = persona.clone();
			double tarifa = i+0.0;
			clon.setTarifa(tarifa);
			System.out.println(clon.toString());
			lista[i] = clon;
			}
	}

}
