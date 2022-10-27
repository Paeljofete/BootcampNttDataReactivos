package com.example.webFluxMicro;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Service
public class PersonService {

	public Flux<Person> allPersons(){
		Flux<Person> person1 = WebClient.create("http://localhost:8080/person-list1").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> person2 = WebClient.create("http://localhost:8080/person-list2").get().retrieve().bodyToFlux(Person.class);;
		Flux<Person> person3 = WebClient.create("http://localhost:8080/person-list3").get().retrieve().bodyToFlux(Person.class);;
		Flux<Person> person4 = WebClient.create("http://localhost:8080/person-list4").get().retrieve().bodyToFlux(Person.class);;
		
		Flux<Person> allFlux = Flux.merge(person1, person2, person3, person4);
		return allFlux;
	}
}
