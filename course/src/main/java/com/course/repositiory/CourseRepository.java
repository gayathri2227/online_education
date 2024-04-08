package com.course.repositiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	Optional<Course> findByCourseName(String name);

	Optional<Course> findByCourseId(long id);

}
