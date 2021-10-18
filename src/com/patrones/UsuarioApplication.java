package com.patrones;

import com.patrones.builders.RecursoBuilder;
import com.patrones.builders.UsuarioBuilder;
import com.patrones.estados.Estados;
import com.patrones.estados.Recurso;
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
		for (int i = 0; i < 5; i++) {
			PersonaTarifa1 clon = persona.clone();
			double tarifa = i + 0.0;
			clon.setTarifa(tarifa);
			System.out.println(clon.toString());
			lista[i] = clon;
		}

		// Práctica Máquina de estados

		// Creamos primer objeto con builder
		Recurso res = new RecursoBuilder().build("Recurso", null);

		// Clonamos el primer objeto en el segundo y cambiamos el nombre
		Recurso res2 = res.clone();
		res2.setNombre("Recurso 2");

		// Inicializamos los contadores de cada vez que se actualiza el estado de cada
		// Recurso
		int contador1 = 0;
		int contador2 = 0;

		int limite = 5;

		// Comienza el bucle
		for (int i = 0; i < 15; i++) {

			// Sacamos por pantalla el número de bucles y la info de cada Recurso
			System.out.println(i);
			System.out.println(res);
			System.out.println(res2);

			// Comprobamos el estado de los recursos: si alguno está Cerrado, acaba el bucle
			if (res.getEstado() == Estados.CLOSED || res2.getEstado() == Estados.CLOSED) {
				break;
			}

			// Cambiamos el valor de uno de los recursos para comprobar que se actualiza el
			// estado
			// en caso de que el Recurso al final funcione
			if (i == 3) {
				res.setValor(8);
			}

			// Se comprueba si el valor es correcto ahora en ambos Recursos
			if (res.getValor() != null) {
				res.setEstado(Estados.OPEN);
				contador1 = 0;
			}
			if (res2.getValor() != null) {
				res.setEstado(Estados.OPEN);
			}

			// Si alguno de los recursos tiene el valor en null, se comienza a actualizar su contador.
			//Primero se comprueba el primer recurso, y cuando éste sea correcto, se comienza a comprobar
			//el siguiente, de forma que se hagan las 5 iteraciones después de que el primero ya se haya corregido
			if (res.getValor() == null) {
				if (res.getEstado() == Estados.OPEN) {
					res.setEstado(Estados.HALF_OPEN);
					contador1++;
				} else if (res.getEstado() == Estados.HALF_OPEN && contador1 < limite) {
					contador1++;
				} else if (res.getEstado() == Estados.HALF_OPEN && contador1 == limite) {
					res.setEstado(Estados.CLOSED);
					contador1++;
				}
				
			} else if (res2.getValor() == null) {
				if (res2.getEstado() == Estados.OPEN) {
					res2.setEstado(Estados.HALF_OPEN);
					contador2++;
				} else if (res2.getEstado() == Estados.HALF_OPEN && contador2 < limite) {
					contador2++;
				} else if (res2.getEstado() == Estados.HALF_OPEN && contador2 == limite) {
					res2.setEstado(Estados.CLOSED);
					contador2++;
				}

			}
		}

	}

}
