package com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA;

import com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findAll();

    @Query(nativeQuery=true, value="SELECT * FROM student x WHERE s.last_name LIKE %x%")
    List<Student> findByLastNameLike(@Param("last_name") String x);

    @Modifying
    @Query(nativeQuery=true, value="DELETE FROM student WHERE id = ?1")
    public void deleteById(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery=true, value="DELETE FROM student WHERE last_name LIKE %?1")
    public void deleteByLastNameEnds(Character x);

    @Modifying
    @Transactional
    @Query(nativeQuery=true, value="DELETE FROM student WHERE first_name LIKE ?1%")
    public void deleteByFirstNameStarts(Character x);
}
