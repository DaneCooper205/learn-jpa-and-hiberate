package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.CoursePojo;

@Repository
public class CourseJdbcRepository {
	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY = """
				insert into course(id,name,author)
				values(1,'Learn AWS','in28minutes');
			""";
	
	private static String INSERT_QUERY_PARAM = """
			insert into course(id,name,author)
			values(?,?,?);
		""";
	private static String DELETE_QUERY_PARAM = """
			delete from course where id = ?;
		""";
	
	private static String SELECT_QUERY_PARAM = """
			select * from course where id = ?;
		""";
	
	public void insert() {
		springJdbcTemplate.update(INSERT_QUERY );
	}
	
	public void insert(CoursePojo course) {
		springJdbcTemplate.update(INSERT_QUERY_PARAM, course.getId(), course.getName(), course.getAuthor() );
	}
	
	public void deleteById(long id ) {
		springJdbcTemplate.update( DELETE_QUERY_PARAM, id);
	}
	
	public CoursePojo findById( long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY_PARAM, new BeanPropertyRowMapper<>(CoursePojo.class ), id);
	}
}
