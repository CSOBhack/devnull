package cz.csob.hackathon.devnull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = { "cz.csob.hackathon.devnull" })
@EntityScan(basePackages = { "cz.csob.hackathon.devnull.db.entity" })
@EnableJpaRepositories(basePackages = { "cz.csob.hackathon.devnull.db.repository" })
@EnableAutoConfiguration
public class Start {

	public static void main(String[] args) {
		Configurer.config();
		SpringApplication.run(Start.class, args);
	}
}
