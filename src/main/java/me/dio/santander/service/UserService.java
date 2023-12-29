package me.dio.santander.service;

import me.dio.santander.domain.model.User;

//aqui estamos criando uma interface para definir as operações para os usuários
/*
 * aqui não vamos expor as implementações da user
 */
public interface UserService {
	User findById(Long id);
	
	User create(User user);
	
	User createFormatoDois(User user);
	

}
