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
		Recurso res = new RecursoBuilder().build("Recurso", null);
		Recurso res2 = res.clone();
		res2.setNombre("Recurso 2");
		int i;
		
		for(i = 0; i<10;) {
			if(res.getEstado()==Estados.CLOSED || res2.getEstado()==Estados.CLOSED) {
				System.out.println(i);
				System.out.println(res);
				System.out.println(res2);
				break;
			}
			System.out.println(i);
			System.out.println(res);
			System.out.println(res2);
			if (i == 3) {
				res.setValor(8);
			}
			if (res.getValor() == null) {
				if (res.getEstado() == Estados.OPEN) {
					res.setEstado(Estados.HALF_OPEN);
					i++;
				}else if (res.getEstado() == Estados.HALF_OPEN && i<5) {
					i++;
				}else if (res.getEstado() == Estados.HALF_OPEN && i==5) {
					res.setEstado(Estados.CLOSED);
					i++;
				}
			}else if (res2.getValor() == null) {
				if (res2.getEstado() == Estados.OPEN) {
					res2.setEstado(Estados.HALF_OPEN);
					i++;
				}else if (res2.getEstado() == Estados.HALF_OPEN && i<5) {
					i++;
				}else if (res2.getEstado() == Estados.HALF_OPEN && i==5) {
					res2.setEstado(Estados.CLOSED);
					i++;
				}
		
			}
		}

	}

}
