package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ru.kata.spring.boot_security.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//        @EntityGraph(value = User.ROLE)
//    @Query("select u from User u where u.username = :username")
    User findByUsername(String username);

    @EntityGraph(value = User.ROLE)
    @Query("select u from User u where u.email = :email")
    User findByEmail(String email);

    User findByName(String name);

}