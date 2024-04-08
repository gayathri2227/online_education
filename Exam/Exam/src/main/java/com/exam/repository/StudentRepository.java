package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.Student;
import com.google.common.base.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

   public 	Optional<Student> findByStudentId(long id);

}
