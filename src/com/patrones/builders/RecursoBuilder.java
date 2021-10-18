package com.patrones.builders;

import com.patrones.estados.Estados;
import com.patrones.estados.Recurso;

public class RecursoBuilder {
	
	public Recurso build(String nombre, Integer valor) {
		Recurso recurso = new Recurso();
		recurso.setNombre(nombre);
		recurso.setValor(valor);
		recurso.setEstado(Estados.OPEN);
		return recurso;
	}

}
