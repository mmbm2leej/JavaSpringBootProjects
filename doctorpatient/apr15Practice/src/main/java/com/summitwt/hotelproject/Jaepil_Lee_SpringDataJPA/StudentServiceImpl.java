package com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo stuRepo;

    @Override
    public List<Student> findAll() {
        return stuRepo.findAll();
    }

    @Override
    public void deleteStudentID(Long id) {
        stuRepo.deleteById(id);
        System.out.println("Deleted record with ID: " + id);
    }

    @Override
    public Student getStudent(Long id) {
        return stuRepo.getOne(id);
    }
}
