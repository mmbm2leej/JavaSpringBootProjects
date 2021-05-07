package com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepo extends JpaRepository<Users, Long> {
    List<Users> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE users.id = ?1")
    public Users findByID(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE users.username = ?1 AND users.password = ?2")
    public Users findByLogIn(String username, String pass);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM users WHERE users.id = ?1")
    public void deletebyid(Long testID);

    @Query(nativeQuery = true, value = "SELECT firstname FROM users WHERE id = ?1")
    public Users findFirstNameById(Long id);

    @Query(nativeQuery = true, value = "SELECT lastname FROM users WHERE id = ?1")
    public Users findLastNameById(Long id);

}
