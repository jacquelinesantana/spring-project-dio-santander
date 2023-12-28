package me.dio.santander.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String number;
	
	private String agency;
	
	
	private Float balance;
	
	//não aceita valor nulo, aceita até 13 digitos sendo 2 casa decimal
	@Column(name = "additional_limit",nullable= false )
	private Float limit;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public Float getLimit() {
		return limit;
	}
	public void setLimit(Float limit) {
		this.limit = limit;
	}
	
}
