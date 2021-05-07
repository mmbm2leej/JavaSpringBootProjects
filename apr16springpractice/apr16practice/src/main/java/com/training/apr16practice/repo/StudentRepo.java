package com.training.apr16practice.repo;

import com.training.apr16practice.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query("FROM students")
    public List<Student> findAll();

    @Query("COUNT(*) FROM students")
    public long count();

    @Query("FROM students WHERE id = ?1")
    public Student findByID(Long id);

    @Query("FROM students WHERE first_name LIKE '%?1%'")
    public List<Student> findByFirstNameLike(String part);

    @Query("FROM students WHERE last_name LIKE %?1%")
    public List<Student> findByLastNameLike(String part);

    @Query("FROM students WHERE last_name LIKE %?1")
    public List<Student> lastNameEndsWith(String ender);

    @Query("FROM students WHERE first_name LIKE ?1%")
    public List<Student> firstNameStartWith(String beginner);
}
