package me.dio.santander.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.santander.domain.model.User;
import me.dio.santander.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	//estamos injetando aqui a camada que é a interface
	private final UserService userService;
	
	//aqui temos o método construtor para garantir que esses objetos dessa classe precisam acessar o userService
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		var user  = userService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping 
	public ResponseEntity<User> create(@RequestBody User user){
		var userCreated  = userService.create(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userCreated.getId()).toUri();
		return ResponseEntity.created(location).body(userCreated);
	}
	
}
