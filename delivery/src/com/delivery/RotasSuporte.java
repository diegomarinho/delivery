package com.delivery;

import java.util.ArrayList;
import java.util.Hashtable;

public class RotasSuporte {
	
	protected static final int VALOR_ZERO = 0;

	protected static final int VALOR_UM = 1;

	protected static final int VALOR_DOIS = 2;

	protected static final String NENHUM_CAMINHO = "NENHUM CAMINHO";
	
	protected Hashtable<Nodo, Aresta> tabelaRotas;
	
	/**
	 * 
	 */
	public RotasSuporte() {
		this.tabelaRotas = new Hashtable<Nodo, Aresta>();
	}
	
	/**
	 * Metodo responsavel por verificar a distancia de um determinado caminho percorrido.
	 * 
	 * @param cidades
	 * @return
	 * @throws Exception
	 */
	protected int buscaDistancia(ArrayList<Nodo> cidades) throws Exception {

		int cont = VALOR_ZERO;
		int distancia = VALOR_ZERO;
		int limiarProfundidade = VALOR_ZERO;
		
		if (cidades.size() < VALOR_DOIS) {
			return VALOR_ZERO;
		}
		
		while (cont < cidades.size() - VALOR_UM) {
			
			if (this.tabelaRotas.containsKey(cidades.get(cont))) {
				
				Aresta caminho = this.tabelaRotas.get(cidades.get(cont));
				
				while (caminho != null) {
					
					if (caminho.destino.equals(cidades.get(cont + VALOR_UM))) {
						distancia += caminho.peso;
						limiarProfundidade++;
						break;
					}
					
					caminho = caminho.proximaRota;
				}
			} else {
				throw new Exception(NENHUM_CAMINHO);
			}
			
			cont++;
		}
		
		if (limiarProfundidade != cidades.size() - VALOR_UM) {
			throw new Exception(NENHUM_CAMINHO);
		}

		return distancia;
	}

	/**
	 * Metodo responsavel por verificar a quantidade de paradas ocorridas em um determinado caminho percorrido.
	 * 
	 * @param inicio
	 * @param fim
	 * @param limiarProfundidade
	 * @param maxParadas
	 * @return
	 * @throws Exception
	 */
	protected int buscaQtdeParadaOcorridaCaminho(Nodo inicio, Nodo fim, int limiarProfundidade, int maxParadas) throws Exception {

		int caminhos = VALOR_ZERO;

		if (this.tabelaRotas.containsKey(inicio) && this.tabelaRotas.containsKey(fim)) {

			limiarProfundidade++;

			if (limiarProfundidade > maxParadas) {
				return VALOR_ZERO;
			}

			inicio.visitado = true;
			Aresta aresta = this.tabelaRotas.get(inicio);

			while (aresta != null) {

				if (aresta.destino.equals(fim)) {
					caminhos++;
					aresta = aresta.proximaRota;
					continue;
				}

				else if (!aresta.destino.visitado) {
					caminhos += buscaQtdeParadaOcorridaCaminho(aresta.destino, fim, limiarProfundidade, maxParadas);
					limiarProfundidade--;
				}

				aresta = aresta.proximaRota;
			}
		} else {
			throw new Exception(NENHUM_CAMINHO);
		}

		inicio.visitado = false;

		return caminhos;
	}
	
	/**
	 * Metodo responsavel por verificar o melhor caminho percorrido.
	 * 
	 * @param inicio
	 * @param fim
	 * @param peso
	 * @param melhorRota
	 * @return
	 * @throws Exception
	 */
	protected int buscaMelhorCaminho(Nodo inicio, Nodo fim, int peso, int melhorRota) throws Exception {
		
		if (this.tabelaRotas.containsKey(inicio) && this.tabelaRotas.containsKey(fim)) {
			
			inicio.visitado = true;
			Aresta aresta = this.tabelaRotas.get(inicio);
			
			while (aresta != null) {
				
				if (aresta.destino == fim || !aresta.destino.visitado) {
					peso += aresta.peso;
				}

				if (aresta.destino.equals(fim)) {
					
					if (melhorRota == VALOR_ZERO || peso < melhorRota) {
						melhorRota = peso;
					}
					
					inicio.visitado = false;
					
					return melhorRota;
				}
				
				else if (!aresta.destino.visitado) {
					melhorRota = buscaMelhorCaminho(aresta.destino, fim, peso, melhorRota);
					peso -= aresta.peso;
				}
				
				aresta = aresta.proximaRota;
			}
		} else {
			throw new Exception(NENHUM_CAMINHO);
		}

		inicio.visitado = false;

		return melhorRota;

	}

	/**
	 * Metodo responsavel por verificar o viabilidade/latencia do percurso ocorrido em um determinado caminho.
	 * 
	 * @param inicio
	 * @param fim
	 * @param peso
	 * @param maxDistancia
	 * @return
	 * @throws Exception
	 */
	protected int buscaViabilidadeCaminho(Nodo inicio, Nodo fim, int peso, int maxDistancia) throws Exception {
		
		int caminho = VALOR_ZERO;
		
		if (this.tabelaRotas.containsKey(inicio) && this.tabelaRotas.containsKey(fim)) {
			
			Aresta aresta = this.tabelaRotas.get(inicio);
			
			while (aresta != null) {
				
				peso += aresta.peso;
				
				if (peso <= maxDistancia) {
					
					if (aresta.destino.equals(fim)) {
						
						caminho++;
						caminho += buscaViabilidadeCaminho(aresta.destino, fim, peso, maxDistancia);
						aresta = aresta.proximaRota;
						continue;
						
					} else {
						
						caminho += buscaViabilidadeCaminho(aresta.destino, fim, peso, maxDistancia);
						peso -= aresta.peso;
						
					}
					
				} else {
					peso -= aresta.peso;
				}

				aresta = aresta.proximaRota;
			}
		} else {
			throw new Exception(NENHUM_CAMINHO);
		}

		return caminho;

	}
}
