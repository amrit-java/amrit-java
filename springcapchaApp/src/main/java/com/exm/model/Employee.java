package com.exm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
//The @Data annotation is part of Project Lombok, a Java library that helps reduce boilerplate code in your classes. The @Data annotation automatically generates common methods for classes, such as getters, setters, equals, hashCode, and toString, without the need to write them explicitly.
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Double salary;
	@Transient
	private String captcha;
	@Transient
	private String hidden;
	@Transient
	private String image;
	
}
