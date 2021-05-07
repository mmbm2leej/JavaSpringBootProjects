package com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public List<Student> findAll();

    public void deleteStudentID(Long id);

    public Student getStudent(Long id);

}
