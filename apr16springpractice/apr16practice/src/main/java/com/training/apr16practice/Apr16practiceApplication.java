package com.training.apr16practice;

import com.training.apr16practice.entities.Student;
import com.training.apr16practice.repo.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Apr16practiceApplication {

	public static void main(String[] args) {
		ApplicationContext myContext = SpringApplication.run(Apr16practiceApplication.class, args);
	}

	@Bean
	CommandLineRunner myCLR(StudentRepo myRepo) {
		return args -> {
			Student x = new Student();
			x.setEmail("age3agtaeg@outlook.com");
			x.setFirst_name("Jonathan");
			x.setLast_name("Miller");
			myRepo.save(x);

			//System.out.println(myRepo.count());
			//myRepo.deleteById(1L);
			//System.out.println(myRepo.findAll());

		};
	}

}



