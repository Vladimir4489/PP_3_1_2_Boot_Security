package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping()
    public String adminPage() {
        return "admin/admin";
    }

    @GetMapping("/newUser")
    public String newUser(Model model) {
        List<Role> roleList = roleService.getAllRoles();
        model.addAttribute("user", new User());
        model.addAttribute("list", roleList);
        return "admin/newUser";
    }

    @PostMapping("/createNewUser")
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/allUsers";
    }

    @GetMapping("/allUsers")
    public String showAllUsers(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "admin/allUsers";
    }

    @GetMapping("/{id}/updateInfo")
    public String updateUser(@PathVariable("id") int id, Model model) {
        List<Role> roleList = roleService.getAllRoles();
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("list", roleList);
        return "admin/updateUser";
    }

    @PatchMapping("/{id}/updateUser")
    public String showUpdatedUser(@PathVariable("id") int id, User user) {
        userService.update(user);
        return "redirect:/admin/allUsers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin/allUsers";
    }
}