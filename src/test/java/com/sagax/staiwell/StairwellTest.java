package com.sagax.staiwell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sagax.stairwell.dto.StairwellDTO;
import com.sagax.stairwell.servidor.Servidor;

import junit.framework.Assert;


public class StairwellTest {

	private HttpServer server;
	private Client client;
	private WebTarget target;

	@Before
	public void startServidor() {
		server = Servidor.inicializaServer();
		this.client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080");
	}

	@After
	public void stopServidor() {
		server.stop();
	}

	@Test
	public void testTotalStride(){
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(17, 17));
		String conteudo = requestTotalStride(list, 3);
		Assert.assertEquals("{total stride: 14}", conteudo);
		
		list = new ArrayList<>();
		list.add(17);
		conteudo = requestTotalStride(list, 3);
		Assert.assertEquals("{total stride: 6}", conteudo);
		
		list = new ArrayList<>();
		list.addAll(Arrays.asList(4, 9, 8, 11, 7, 20, 14));
		conteudo = requestTotalStride(list, 2);
		Assert.assertEquals("{total stride: 50}", conteudo);
	}

	private String requestTotalStride(List<Integer> list, int stepsPerStride) {
		StairwellDTO model = new StairwellDTO();
		model.setListFlight(list);
		model.setStepsPerStride(stepsPerStride);
		Entity<StairwellDTO>  entity = Entity.entity(model, MediaType.APPLICATION_JSON);
		String conteudo = target.path("/stairwell/totalStrides").request().post(entity, String.class);
		return conteudo;
	}
}
