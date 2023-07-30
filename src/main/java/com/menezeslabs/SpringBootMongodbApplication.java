package com.menezeslabs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringBootMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			Address address = Address.builder()
					.country("England")
	 				.city("London")
					.postCode("NE9")
					.build();

			Student student	= Student.builder()
					.firstName("Jahmed")
					.lastName("Ahmed")
					.email("jahmed@gmail.com")
					.gender(Gender.FEMALE)
					.address(address)
					.favouriteSubjects(List.of("Computer Science"))
					.totalSpendInBooks(BigDecimal.TEN)
					.created(LocalDateTime.now())
					.build();

			repository.insert(student);
		};
	}
}
