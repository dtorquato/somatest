package com.douglastorquato.somaapp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.douglastorquato.somaapp.enums.TypeEnum;

@Table(name = "tb_cad_tra")
@Entity
public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tra")
	private Integer id;
	
	@Column(name = "dt_tra", columnDefinition = "varchar(10) ", nullable = false)
	private LocalDate dateTransaction;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tx_typ", columnDefinition = "varchar(2) ", nullable = false)
	private TypeEnum type;
	
	@Column(name = "vl_pay", columnDefinition = "decimal(11,2)", nullable = false)
	private Integer value;

	@ManyToOne
	@JoinColumn(name = "id_ent", nullable = false)
	private Enterprise enterprise;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(LocalDate dateTransaction) {
		this.dateTransaction = dateTransaction;
	}



	public String getType() {
		return type.getDescription();
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	

	
}
