package me.dio.santander.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_card")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCard;
	
	@Column(unique = true)
	private String number;
	
	//não aceita valor nulo, aceita até 13 digitos sendo 2 casa decimal
	@Column(name = "additional_limit",nullable= false )
	private Double limit; 
	
	
	public Long getIdCard() {
		return idCard;
	}
	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Double getLimit() {
		return limit;
	}
	public void setLimit(Double limit) {
		this.limit = limit;
	}
	
	
}
