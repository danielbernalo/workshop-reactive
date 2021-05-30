package com.nexllence.workshops.reactive.architecture.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHttpVerticle extends AbstractVerticle {

	private final Logger logger = LoggerFactory.getLogger(ServerHttpVerticle.class);

	@Override
	public void start() throws Exception {
		Router router = Router.router(vertx);
		router.get("/hello").handler(this::greetingHandler);

		vertx.createHttpServer()
			.requestHandler(router)
			.listen(8080);

	}

	private void greetingHandler(RoutingContext context) {
		vertx.executeBlocking(future -> {
			future.complete(greeting());
		}, false,
			response -> handlerAsyncResponse(response, context));

	}

	private void handlerAsyncResponse(AsyncResult<Object> response, RoutingContext context) {
		if (response.succeeded()) {
			context.end(response.result().toString());
		} else {
			context.fail(response.cause());
		}
	}

	private String greeting()  {
		return "Hello World!";
	}
}
