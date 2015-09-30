package com.delivery;

import java.util.ArrayList;

/**
 * @author diego.almeida
 *
 */
public class Rotas extends RotasSuporte {
	
	protected int verificaDistancia(ArrayList<Nodo> cidades) throws Exception {
		return this.buscaDistancia(cidades);
	}

	protected int verificaQtdeParadaOcorridaCaminho(Nodo inicio, Nodo fim, int maxParadas) throws Exception {
		return this.buscaQtdeParadaOcorridaCaminho(inicio, fim, VALOR_ZERO, maxParadas);
	}

	protected int verificaMelhorCaminho(Nodo inicio, Nodo fim) throws Exception {
		return this.buscaMelhorCaminho(inicio, fim, VALOR_ZERO, VALOR_ZERO);
	}

	protected int verificaViabilidadeCaminho(Nodo inicio, Nodo fim, int maxDistancia) throws Exception {
		return this.buscaViabilidadeCaminho(inicio, fim, VALOR_ZERO, maxDistancia);
	}

}