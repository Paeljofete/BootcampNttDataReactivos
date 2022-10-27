package com.example.webFluxMicro;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping("/person-list1")
	public Flux<Person> personList1() {

		Flux<Person> flux = Flux.just(new Person("Hector", "FerSan", 6)).delayElements(Duration.ofSeconds(2));

		return flux;
	}

	@GetMapping("/person-list2")
	public Flux<Person> personList2() {

		Flux<Person> flux = Flux.just(new Person("Beren", "San", 3)).delayElements(Duration.ofSeconds(2));

		return flux;
	}

	@GetMapping("/person-list3")
	public Flux<Person> personList3() {

		Flux<Person> flux = Flux.just(new Person("Ciro", "Fer", 1)).delayElements(Duration.ofSeconds(2));

		return flux;
	}

	@GetMapping("/person-list4")
	public Flux<Person> personList4() {

		Flux<Person> flux = Flux.just(new Person("Tuko", "Can", 7)).delayElements(Duration.ofSeconds(2));

		return flux;
	}
}
