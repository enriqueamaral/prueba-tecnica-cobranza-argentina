package com.pruebatecnica.prueba_tecnica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.prueba_tecnica.entity.Users;

@Repository
public interface UserRepository extends JpaRepository <Users, Integer> {
    Optional<Users> findByUserName(String userName);
}
