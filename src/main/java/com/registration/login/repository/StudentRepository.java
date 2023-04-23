package com.registration.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.login.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
