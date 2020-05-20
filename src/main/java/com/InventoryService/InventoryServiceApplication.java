package com.InventoryService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String nom;
	private double price;

	public Product(String nom, double price) {
		this.nom=nom;
		this.price=price;
	}

	public Long getId() {
		return this.id;
	}
}


@RepositoryRestResource
interface InventoryRepository extends JpaRepository<Product,Long> {
}
@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(InventoryRepository ir,RepositoryRestConfiguration RepositoryRestConfiguration)
	{
		return args ->{
			RepositoryRestConfiguration.exposeIdsFor(Product.class);
			ir.save(new Product("ddd",123) );
			ir.save(new Product("ffff",333));
			ir.save(new Product("ccc",444));
		};
	}
}
class Customer {
	private long id;
	private String nom;
	private String email;
	public Customer(String nom,String email)
	{
		this.nom=nom;
		this.email=email;
	}

	public Customer() {

	}

	public Long getId() {
		return this.id;
	}

}

@Component
class CustomerKafkaListener {
	private Customer customer=new Customer();
	private final Logger log = LoggerFactory.getLogger(CustomerKafkaListener.class);






}


