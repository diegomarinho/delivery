package com.delivery;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class TestRotas extends TestRotasSuporte {
	
	// 01
	@Test
	public void testQuestao_1() throws Exception {
		ArrayList<Nodo> caminho = new ArrayList<Nodo>();
		caminho.addAll(Arrays.asList(A, D, E));
		assertEquals(MSG_VALOR_INFORMADO_INCORRETAMENTE, 5, rota.verificaDistancia(caminho));
	}

	// 02
	@Test
	public void testQuestao_2() throws Exception {
		exception.expect(Exception.class);
		ArrayList<Nodo> caminho = new ArrayList<Nodo>();
		caminho.addAll(Arrays.asList(A, F, E));
		assertEquals(MSG_VALOR_INFORMADO_INCORRETAMENTE, MSG_NENHUM_CAMINHO, rota.verificaDistancia(caminho));
	}

	// 03
	@Test
	public void testQuestao_3() throws Exception {
		ArrayList<Nodo> caminho = new ArrayList<Nodo>();
		caminho.addAll(Arrays.asList(E, C, B));
		assertEquals(MSG_VALOR_INFORMADO_INCORRETAMENTE, 10, rota.verificaDistancia(caminho));
	}

	// 04
	@Test
	public void testQuestao_4() throws Exception {
		exception.expect(Exception.class);
		ArrayList<Nodo> caminho = new ArrayList<Nodo>();
		caminho.addAll(Arrays.asList(B, D, F, E));
		assertEquals(MSG_VALOR_INFORMADO_INCORRETAMENTE, MSG_NENHUM_CAMINHO, rota.verificaDistancia(caminho));
	}

	// 05
	@Test
	public void testQuestao_5() throws Exception {
		ArrayList<Nodo> caminho = new ArrayList<Nodo>();
		caminho.addAll(Arrays.asList(F, C));
		assertEquals(MSG_VALOR_INFORMADO_INCORRETAMENTE, 5, rota.verificaDistancia(caminho));
	}
	
	// 06
	@Test
	public void testQuestao_6() throws Exception {
		
		// FIXME - Arriving the client 'C':
		// [A, C, 9], [E, C, 8], [F, C, 5]
		// Count = 3
		
		// ---------------------------------

		// FIXME - Starting from 'C'
		// [C, B, 2]
		// Count = 1
		
	}
	
	// 07
	@Test
	public void testQuestao_7() throws Exception {
		int numStops = rota.verificaQtdeParadaOcorridaCaminho(B, A, 5);
		assertEquals(MSG_VALOR_INFORMADO_INCORRETAMENTE, 2, numStops);
	}
	
	// 08
	@Test
	public void testQuestao_8() throws Exception {
		int numStops = rota.verificaQtdeParadaOcorridaCaminho(A, A, 3);
		assertEquals(MSG_VALOR_INFORMADO_INCORRETAMENTE, 3, numStops);
	}
	
	// 09
	@Test
	public void testQuestao_9() throws Exception {
		int shortestRoute = rota.verificaMelhorCaminho(A, E);
		assertEquals(MSG_VALOR_INFORMADO_INCORRETAMENTE, 5, shortestRoute);
	}

	// 10
	@Test
	public void testQuestao_10() throws Exception {
		int shortestRoute = rota.verificaMelhorCaminho(C, E);
		assertEquals(MSG_VALOR_INFORMADO_INCORRETAMENTE, 6, shortestRoute);
	}
	
	// 11
	@Test
	public void testQuestao_11() throws Exception {
		int numRoutesWithin = rota.verificaViabilidadeCaminho(A, B, 40);
		assertEquals(MSG_VALOR_INFORMADO_INCORRETAMENTE, 26, numRoutesWithin);
	}

	// 12
	@Test
	public void testQuestao_12() throws Exception {
		int numRoutesWithin = rota.verificaViabilidadeCaminho(E, D, 60);
		assertEquals(MSG_VALOR_INFORMADO_INCORRETAMENTE, 102, numRoutesWithin);
	}

}