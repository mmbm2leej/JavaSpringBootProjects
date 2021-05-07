package com.training.apr16practice;

import com.training.apr16practice.entities.Student;
import com.training.apr16practice.repo.StudentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Apr16practiceApplicationTests {

	@Test
	void contextLoads() {
	}
	/*
	@Autowired
	private StudentRepo stuRepo;



	@Test public void testCreateCustomer() {
		Student x = new Student();
	 	x.setEmail("age3agtaeg@outlook.com");
	 	x.setFirst_name("Jonathan");
	 	x.setLast_name("Miller");
		stuRepo.save(x);
	}
*/
}
