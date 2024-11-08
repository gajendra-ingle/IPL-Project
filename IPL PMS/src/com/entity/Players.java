package com.entity;

public class Players {

	private String name;
	private String role;
	private int age;

	public Players(String name, String role, int age) {
		super();
		this.name = name;
		this.role = role;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Players [name=" + name + ", role=" + role + ", age=" + age + "]";
	}

}
