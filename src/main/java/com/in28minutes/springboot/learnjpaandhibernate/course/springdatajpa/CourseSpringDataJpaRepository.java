package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.CourseJPA;

public interface CourseSpringDataJpaRepository extends JpaRepository<CourseJPA, Long>{
	List<CourseJPA> findByAuthor(String author);

}
