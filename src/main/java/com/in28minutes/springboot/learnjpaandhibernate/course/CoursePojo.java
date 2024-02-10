package com.in28minutes.springboot.learnjpaandhibernate.course;

public class CoursePojo {
	private long id;
	private String name;
	private String author;

	public CoursePojo() {

	}

	public CoursePojo(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	@Override
	public String toString() {
		return "CoursePojo [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

}
