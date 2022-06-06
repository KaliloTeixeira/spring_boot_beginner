package com.example.project_4;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Project4Application {

	private static final Logger log = LoggerFactory.getLogger(Project4Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Project4Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository){
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Kalilo", "Teixeira"));
			repository.save(new Customer("Joao", "Jesus"));
			repository.save(new Customer("Ney", "Mar"));
			repository.save(new Customer("Janet", "Teixeira"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual Customer by ID
			Customer customer = repository.findById(1);
			log.info("Customers found with findById():");
			log.info("-------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch Customers by last name
			log.info("Customers found with findByLastName():");
			log.info("-------------------------------");
			repository.findByLastName("Teixeira").forEach(register -> {
				log.info(register.toString());
			});
			log.info("");

		};
	}

}
