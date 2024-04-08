package com.exam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

	Optional<Exam>findByExamId(long id);

}
