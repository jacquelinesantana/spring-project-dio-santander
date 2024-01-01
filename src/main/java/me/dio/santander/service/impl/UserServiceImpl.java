package me.dio.santander.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import me.dio.santander.domain.model.User;
import me.dio.santander.domain.repository.UserRepository;
import me.dio.santander.service.UserService;
//aqui vamos implementar a interface com as assinaturas das a��es do usu�rio

@Service
public class UserServiceImpl implements UserService{

	
	private final UserRepository userRepository;
	
	//m�todo construtor para o spring entender que para criar esse objeto ele precisa injetar o user repository
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User getById(Long id) {
		// aqui vamos buscar pelo id, caso n�o encontre ele usa essa exce��o do java para tratar esse n�o retorno do dado
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		// vamos verificar se o numero do id j� existe, caso sim teremos uma excess�o executada com a mensagem 
		if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
			throw new IllegalArgumentException("This user id already exists.");
		}
		return userRepository.save(userToCreate);
	}
	
	@Override
	public User createFormatoDois(User userToCreate) {
		// vamos verificar se o numero da conta j� existe, caso sim teremos uma excess�o executada com a mensagem 
		if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
	}
	
	@Override
	public List<User> findAll(){
		return this.userRepository.findAll();
	}
	
}
