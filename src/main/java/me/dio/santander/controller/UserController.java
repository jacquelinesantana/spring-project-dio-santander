package me.dio.santander.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.santander.domain.model.User;
import me.dio.santander.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	
	//estamos injetando aqui a camada que é a interface
	private final UserService userService;
	
	//aqui temos o método construtor para garantir que esses objetos dessa classe precisam acessar o userService
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById2(@PathVariable Long id){
		
		var user = userService.getById(id);
		
		return ResponseEntity.ok(user);
		
		
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		var user = userService.findAll();
		/*var users =  user.stream().map(resp -> resp).collect(Collectors.toList());
		return ResponseEntity.ok(users);*/
		
		return ResponseEntity.ok(userService.findAll());
	}
	
	@PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) {
        var userCreated = userService.createFormatoDois(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
	
}
