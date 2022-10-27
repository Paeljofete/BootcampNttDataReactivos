package com.nttdata.ejemploReactive;

import reactor.core.publisher.Flux;

/**
 * Prueba Reactor.
 *
 */
public class App {
	public static void main(String[] args) {
		Flux<String> messageSender = Flux.just("Mensaje1", "Mensaje2", "Mensaje3");

		messageSender.subscribe(t -> System.out.println("Observer 1. Suscribed"),
				m -> System.out.println("Observer 1. Recieved " + m + "."),
				e -> System.out.println("Observer 1. Error: " + ex.getMessage()),
				c -> System.out.println("Observer 1."));
	}
}
