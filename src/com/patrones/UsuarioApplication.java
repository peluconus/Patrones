package com.patrones;

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
		Recurso res = new Recurso("Recurso", null);
		Recurso res2 = new Recurso("Recurso 2", null);
		int i ;
		
		for(i = 0; i<6;) {
			Integer valor = res.getValor();
			Integer valor2 = res2.getValor();
			Estados est = res.getEstado();
			Estados est2 = res2.getEstado();
			System.out.println(valor);
			System.out.println(valor2);
			System.out.println(est);
			System.out.println(est2);
			if (i == 3) {
				res.setValor(8);
			}
			if (valor == null) {
				if (res.getEstado() == Estados.OPEN) {
					res.setEstado(Estados.HALF_OPEN);
					i++;
				}else if (res.getEstado() == Estados.HALF_OPEN && i<5) {
					i++;
				}else if (res.getEstado() == Estados.HALF_OPEN && i==5) {
					res.setEstado(Estados.CLOSED);
					i = 0;
					break;
				}
			}else if (valor2 == null) {
				if (res2.getEstado() == Estados.OPEN) {
					res2.setEstado(Estados.HALF_OPEN);
					i++;
				}else if (res2.getEstado() == Estados.HALF_OPEN && i<5) {
					i++;
				}else if (res2.getEstado() == Estados.HALF_OPEN && i==5) {
					res2.setEstado(Estados.CLOSED);
					i = 0;
					break;
				}
		
			}
		}

	}

}
