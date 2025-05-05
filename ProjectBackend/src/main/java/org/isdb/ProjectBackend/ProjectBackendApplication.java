package org.isdb.ProjectBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("org.isdb.ProjectBackend.repository")
@EntityScan("org.isdb.ProjectBackend.model")

@SpringBootApplication
public class ProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectBackendApplication.class, args);
	}

}
