package me.dio.santander.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
/*
 * essa classe abstrata garante que todos os objetos que tiverem esses mesmos atributos
 * reutilizem a mesma fonte de dados e evita mudar algo em um e não alterar no outro
 * garanti-se o padrão
 */
@MappedSuperclass
public abstract class BaseItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDados;
	private String icon;
	private String description;
	
	
	public Long getIdDados() {
		return idDados;
	}
	public void setIdDados(Long idDados) {
		this.idDados = idDados;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
