package com.qsp.srping_employee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private long phone;
	@Column(unique = true)
	private String email;
	private String address;
	private char grade;
	private double salary;

}
