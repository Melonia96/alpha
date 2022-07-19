package com.example.Aub.alpha;

import com.example.Aub.alpha.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class AlphaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlphaApplication.class, args);
	}
	@GetMapping
	public List<Student> hello() {
		return List.of(
				new Student(
						1L,
						"Miriam",
						"miriam.jamal@gmail.com",
						LocalDate.of(2000, Month.JANUARY, 5),
						21)
		);
	}
}


