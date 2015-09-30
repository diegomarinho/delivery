package com.delivery;

/**
 * @author diego.almeida
 * 
 */
public class Aresta {

	public Nodo origem;

	public Nodo destino;

	public int peso;

	public Aresta proximaRota;

	public Aresta(Nodo origem, Nodo destino, int peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
		this.proximaRota = null;
	}

	public Aresta next(Aresta aresta) {
		this.proximaRota = aresta;
		return this;
	}
}