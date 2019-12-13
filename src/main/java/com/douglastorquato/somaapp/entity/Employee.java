package com.douglastorquato.somaapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "tb_cad_emp")
@Entity
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_emp")
	private Integer id;
	
	@Column(name = "tx_emp_nam", columnDefinition = "text", nullable = false)
	private String name;
	
	@Column(name = "tx_emp_rol", columnDefinition = "text", nullable = false)
	private String role;
	
	@OneToOne
	@JoinColumn(name = "id_ent", nullable = false)
	private Enterprise enterprise;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	
	
}
