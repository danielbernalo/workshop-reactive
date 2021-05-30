package com.nexllence.workshops.reactive.architecture.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class Main {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new ServerHttpVerticle());
	}
}
