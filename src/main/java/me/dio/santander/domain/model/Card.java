package me.dio.santander.domain.model;

public class Card {

	private Long id;
	private String number;
	private Double limit;
	
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
	public Double getLimit() {
		return limit;
	}
	public void setLimit(Double limit) {
		this.limit = limit;
	}
	
	
}
