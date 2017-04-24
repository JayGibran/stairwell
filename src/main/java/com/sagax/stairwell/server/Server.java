package com.sagax.stairwell.server;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author JayGibran
 *
 */
public class Server {
	
	private static final String SERVER_ADDRESS = "http://localhost:8080/";
	private static final String PACKAGE_RESOURCE = "com.sagax.stairwell.resource";
			
	public static void main(String[] args) throws IOException{
		HttpServer server = inicializaServer();
		System.out.println("Server running");
		System.in.read();
		server.stop();
	}

	public static HttpServer inicializaServer() {
		ResourceConfig config = new ResourceConfig().packages(PACKAGE_RESOURCE);
		URI uri = URI.create(SERVER_ADDRESS);
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		return server;
	}
	
}
