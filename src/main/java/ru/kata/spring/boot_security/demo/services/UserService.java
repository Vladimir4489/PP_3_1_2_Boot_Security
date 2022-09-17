package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    boolean save(User user);
    List<User> getAllUsers();
    User update(User user);
    User getById(int id);
    boolean delete(int id);
    User findByUsername(String name);

}