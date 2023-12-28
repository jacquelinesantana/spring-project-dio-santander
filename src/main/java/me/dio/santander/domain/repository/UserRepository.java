package me.dio.santander.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.santander.domain.model.User;

//anota��o n�o � obrigatoria pois estamos extendendo o repository da jpa
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
