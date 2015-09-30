package com.delivery;

/**
 * @author diego.almeida
 *
 */
public class Nodo {
	
	public String nome;
	
	public boolean visitado;

	public Nodo(String name) {
		this.nome = name;
		this.visitado = false;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		
		Nodo nodo = (Nodo) obj;
		
		return this.nome.equals(nodo.nome);
	}

	@Override
	public int hashCode() {
		
		if (this.nome == null) {
			return 0;
		}
		
		return this.nome.hashCode();
	}
}