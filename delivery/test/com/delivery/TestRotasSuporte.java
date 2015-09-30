package com.delivery;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class TestRotasSuporte {
	
	protected static final String MSG_NENHUM_CAMINHO = "NENHUM CAMINHO";
	protected static final String MSG_VALOR_INFORMADO_INCORRETAMENTE = "Valor informado incorretamente.";
	
	protected static Nodo A = null;	protected static Nodo B = null;	protected static Nodo C = null;
	protected static Nodo D = null;	protected static Nodo E = null;	protected static Nodo F = null;

	protected Rotas rota = null;
	
	@Before
	public void setUp() throws Exception {
		
		rota = new Rotas();

		A = new Nodo("A");		B = new Nodo("B");		C = new Nodo("C");
		D = new Nodo("D");		E = new Nodo("E");		F = new Nodo("F");

		rota.tabelaRotas.put(A, new Aresta(A, D, 4).next(new Aresta(A, C, 9)));
		rota.tabelaRotas.put(B, new Aresta(B, A, 6).next(new Aresta(B, D, 3)));
		rota.tabelaRotas.put(C, new Aresta(C, B, 2));
		rota.tabelaRotas.put(D, new Aresta(D, E, 1).next(new Aresta(D, F, 7)));
		rota.tabelaRotas.put(E, new Aresta(E, C, 8));
		rota.tabelaRotas.put(F, new Aresta(F, C, 5).next(new Aresta(F, E, 9)).next(new Aresta(F, A, 3)));
	}

	@After
	public void tearDown() throws Exception {

	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

}