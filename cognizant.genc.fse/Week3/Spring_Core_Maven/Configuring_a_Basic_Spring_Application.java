package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



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

@RestController

class cardata{

	@RequestMapping("/petrolcardata")

	public String getpetroldata() {

		return "new ferrari car with v12 petrol engine";

	}

	@RequestMapping("/dieselcardata")

	public String getdieseldata() {

		return "new ferrari car with v12 diesel engine";

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

/*

.   ____          _            __ _ _

/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \

( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \

\\/  ___)| |_)| | | | | || (_| |  ) ) ) )

'  |____| .__|_| |_|_| |_\__, | / / / /

=========|_|==============|___/=/_/_/_/



:: Spring Boot ::                (v3.5.3)



2025-07-06T23:59:08.424+05:30  INFO 25752 --- [demo] [           main] com.example.demo.DemoApplication         : Starting DemoApplication using Java 17.0.11 with PID 25752 (C:\Users\venka\Downloads\demo\demo\target\classes started by venka in C:\Users\venka\Downloads\demo\demo)

2025-07-06T23:59:08.433+05:30  INFO 25752 --- [demo] [           main] com.example.demo.DemoApplication         : No active profile set, falling back to 1 default profile: "default"

2025-07-06T23:59:10.080+05:30  INFO 25752 --- [demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)

2025-07-06T23:59:10.106+05:30  INFO 25752 --- [demo] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]

2025-07-06T23:59:10.107+05:30  INFO 25752 --- [demo] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.42]

2025-07-06T23:59:10.213+05:30  INFO 25752 --- [demo] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext

2025-07-06T23:59:10.216+05:30  INFO 25752 --- [demo] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1681 ms

2025-07-06T23:59:10.961+05:30  INFO 25752 --- [demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'

2025-07-06T23:59:10.976+05:30  INFO 25752 --- [demo] [           main] com.example.demo.DemoApplication         : Started DemoApplication in 3.548 seconds (process running for 4.513)

Assembling the car parts ... 

Current Engine model .

Current Engine Type Petrol v12

Assembling complete

*/