package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	@Autowired
	private CourseJdbcRepository repository;
	
	@Autowired 
	CourseJpaRepository jpa_repository;
	
	@Autowired 
	CourseSpringDataJpaRepository springdataRepository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert();
		repository.insert( new CoursePojo(2,"Learn AWS Now!","in28minutes"));
		repository.insert( new CoursePojo(3,"Learn Azure Now!","in28minutes"));
		repository.insert( new CoursePojo(4,"Learn DevOps Now!","in28minutes"));
		repository.deleteById( 3L);
		
		System.out.println( repository.findById(1));
		
		jpa_repository.insert(new CourseJPA(5,"Learn to fly","in28minutes"));
		jpa_repository.insert(new CourseJPA(6,"Learn to drive","in28minutes"));
		jpa_repository.insert(new CourseJPA(7,"Learn to swim","in28minutes"));
		
		System.out.println(jpa_repository.findById(6));
		jpa_repository.deleteById(5);
		
		springdataRepository.save(new CourseJPA(8,"Learn to Code","in28minutes"));
		springdataRepository.save(new CourseJPA(9,"Learn to GUI","in28minutes"));
		springdataRepository.save(new CourseJPA(10,"Learn to Test","in28minutes"));
		springdataRepository.deleteById(10L);
		System.out.println(springdataRepository.findById(8L) );
		System.out.println( springdataRepository.findById(9L));
		System.out.println( springdataRepository.findAll());
		
	}

}
