package com.sagax.staiwell;

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
import com.sagax.stairwell.server.Server;

import junit.framework.Assert;


/**
 * @author JayGibran
 *
 */
public class StairwellTest {

	private static final String STAIRWELL_TOTAL_STRIDES = "/stairwell/totalStrides";
	private static final String ADDRESS_SERVER = "http://localhost:8080";
	private HttpServer server;
	private Client client;
	private WebTarget target;

	@Before
	public void startServidor() {
		server = Server.inicializaServer();
		this.client = ClientBuilder.newClient();
		target = client.target(ADDRESS_SERVER);
	}

	@After
	public void stopServidor() {
		server.stop();
	}

	@Test
	public void testTotalStride(){

		String conteudo = requestTotalStride(Arrays.asList(17, 17), 3);
		Assert.assertEquals("{total stride: 14}", conteudo);

		conteudo = requestTotalStride(Arrays.asList(17, 17), 2);
		Assert.assertEquals("{total stride: 20}", conteudo);
		
		conteudo = requestTotalStride(Arrays.asList(17), 3);
		Assert.assertEquals("{total stride: 6}", conteudo);
		
		conteudo = requestTotalStride(Arrays.asList(20,20,20), 4);
		Assert.assertEquals("{total stride: 19}", conteudo);
		
		conteudo = requestTotalStride(Arrays.asList(4, 9, 8, 11, 7, 20, 14), 2);
		Assert.assertEquals("{total stride: 50}", conteudo);
	}

	private String requestTotalStride(List<Integer> flights, int stepsPerStride) {
		StairwellDTO model = new StairwellDTO();
		model.setListFlight(flights);
		model.setStepsPerStride(stepsPerStride);
		Entity<StairwellDTO>  entity = Entity.entity(model, MediaType.APPLICATION_JSON);
		String conteudo = target.path(STAIRWELL_TOTAL_STRIDES).request().post(entity, String.class);
		return conteudo;
	}
}
