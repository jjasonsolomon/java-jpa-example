package com.jpa.emp.jpaempproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="employee")
public class Employee {
	private int id;
	private String empName;
	private String branch;
	
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "seqname")
	@SequenceGenerator(name="seqname", sequenceName="seq")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Column(name="branch")
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", branch=" + branch + "]";
	}
}
