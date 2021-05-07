package com.summitwt.hotelproject;

import com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = StudentApplication.class)
@RunWith(SpringRunner.class)
class StudentApplicationTests {

	@Autowired
	private StudentRepo stuRepo;

	@Test
	public void saveEmp() {
		Student s = new Student(
				"Tom",
				"Parsons",
				"aageage@gmail.com",
				25);
		stuRepo.save(s);

		Student t = new Student(
				"Ally",
				"Tomkins",
				"afw3gt3t@gmail.com",
				27);
		stuRepo.save(t);

		Student u = new Student(
				"Stuart",
				"Jones",
				"avzvzxvxz@hotmail.com",
				42);
		stuRepo.save(u);

		Student v = new Student(
				"Bill",
				"Stevens",
				"fhgfhdethr@yahoo.com",
				21);
		stuRepo.save(v);

		Student w = new Student(
				"Tom",
				"Parsons",
				"ykyrj5yhsrgr@gmail.com",
				55);
		stuRepo.save(w);

	}

	@Test
	public List<Student> findAll() {
		return stuRepo.findAll();
	}

	@Test
	public void deleteStudentID() {
		Long passid = 104L;
		stuRepo.deleteById(passid);
	}

	@Test
	public void deleteByLastNameEnds() {
		Character ender = 'n';
		stuRepo.deleteByLastNameEnds(ender);
	};

	@Test
	public void deleteByFirstNameStarts() {
		Character beginner = 'm';
		stuRepo.deleteByFirstNameStarts(beginner);
	};
}
