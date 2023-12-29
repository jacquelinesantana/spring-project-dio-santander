package me.dio.santander.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.santander.domain.model.User;

//anotação não é obrigatoria pois estamos extendendo o repository da jpa
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	//apenas para verificar se existe uma conta com esse valor para o Account que esta relacionado com user
	boolean existsByAccountNumber(String AccountNumber);
}
