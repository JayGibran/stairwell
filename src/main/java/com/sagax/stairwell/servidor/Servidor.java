package com.sagax.stairwell.servidor;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class Servidor {
	
	public static void main(String[] args) throws IOException{
		HttpServer server = inicializaServer();
		System.out.println("Server running");
		System.in.read();
		server.stop();
	}

	public static HttpServer inicializaServer() {
		ResourceConfig config = new ResourceConfig().packages("com.sagax.stairwell.resource");
		URI uri = URI.create("http://localhost:8080/");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		return server;
	}
	
}
