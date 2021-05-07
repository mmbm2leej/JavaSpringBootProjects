package com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		ApplicationContext myContext = SpringApplication.run(StudentApplication.class, args);
	}

	//THIS WORKS
	/*
	@Bean
	CommandLineRunner myCLR(StudentRepo myRepo) {
		return args -> {

			//this works
			Student steve = new Student(
						"Steve",
						"Smith",
						"asdfw@hotmail.com",
						32);
			myRepo.save(steve);


			System.out.println(myRepo.count());
			myRepo.deleteById(1L);
			System.out.println(myRepo.findAll());

		};
	}
*/

}


/*
create spring boot application with Data JPA dependency.DONE
create product java bean with all required annotations for database tables and columns.DONE
update properties file for database.DONE
update pom.xml for database, jpd dependency. DONE
create repo using JpaRepository DONE
finally update spring boot test class, test all methods of the repository.DONE

upload the solutions in TMS website.
 */