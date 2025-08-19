package co.edu.uniminuto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"co.edu.uniminuto.jpa"})
@EntityScan(basePackages = {"co.edu.uniminuto.entity"})
@ComponentScan(basePackages = {"co.edu.uniminuto.controller", "co.edu.uniminuto", "co.edu.uniminuto.repository", "co.edu.uniminuto.services"})

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
