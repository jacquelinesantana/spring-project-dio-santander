package me.dio.santander.service;

import me.dio.santander.domain.model.User;

//aqui estamos criando uma interface para definir as opera��es para os usu�rios
/*
 * aqui n�o vamos expor as implementa��es da user
 */
public interface UserService {
	User findById(Long id);
	
	User create(User user);
	
	User createFormatoDois(User user);
	

}
