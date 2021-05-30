package com.nexllence.workshops.reactive.architecture;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardHttpServer {
	private static final Logger logger = LoggerFactory.getLogger(StandardHttpServer.class);

	public static final int PORT = 8080;

	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
		server.createContext("/hello", new GreetingHandler());
		server.setExecutor(null);
		server.start();
	}

	private static class GreetingHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			String response = getGreeting();
			httpExchange.sendResponseHeaders(200, response.length());
			OutputStream os = httpExchange.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}

		private String getGreeting() {
			return new StringBuilder()
				.append("Hello World!")
				.toString();
		}
	}
}
