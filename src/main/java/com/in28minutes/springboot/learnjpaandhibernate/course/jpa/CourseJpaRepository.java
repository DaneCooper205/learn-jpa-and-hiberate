package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.CourseJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert( CourseJPA course) {
		entityManager.merge(course);
	}
	
	public CourseJPA findById(long id ) {
		return entityManager.find(CourseJPA.class, id);
	}
	
	public void deleteById(long id ) {
		CourseJPA course = this.findById(id);
		entityManager.remove(course);
	}
}
