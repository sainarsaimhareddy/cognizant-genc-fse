package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;



interface Car {

	void engineType();

}



@Component

class petrolEngine implements Car {

	@Override

	public void engineType() {

		System.out.println("Current Engine Type Petrol v12");

	}

}



@Component

class dieselEngine implements Car {

	@Override

	public void engineType() {

		System.out.println("Current Engine Type Diesel v12");

	}

}



interface FerrariService {

	void assembleCarParts();

}



@Service("petrolFerrari")

class ferrariPetrolService implements FerrariService {

	private final Car ferrariPetrol;



	@Autowired

	public ferrariPetrolService(@Qualifier("petrolEngine") Car car) {

		this.ferrariPetrol = car;

	}



	@Override

	public void assembleCarParts() {

		System.out.println("Assembling the car parts ... ");

		System.out.println("Current Engine model ." );

		ferrariPetrol.engineType();

		System.out.println("Assembling complete");

	}

}



@Service("dieselFerrari")

class ferrariDieselService implements FerrariService {

	private final Car ferrariDiesel;



	@Autowired

	public ferrariDieselService(@Qualifier("dieselEngine") Car car) {

		this.ferrariDiesel = car;

	}



	@Override

	public void assembleCarParts() {

		System.out.println("Assembling the car parts ... ");

		System.out.println("Current Engine model ." );

		ferrariDiesel.engineType();

		System.out.println("Assembling complete");

	}

}



@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		FerrariService service = context.getBean("petrolFerrari", FerrariService.class);

		service.assembleCarParts();

	}

}