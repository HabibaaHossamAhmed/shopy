package Ecommerce.example.Shopy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@Configuration
@EnableJpaAuditing
public class ShopyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopyApplication.class, args);
	}

}
