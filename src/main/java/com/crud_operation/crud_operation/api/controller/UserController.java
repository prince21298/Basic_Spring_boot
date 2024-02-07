package com.crud_operation.crud_operation.api.controller;

import com.crud_operation.crud_operation.api.response.ResponseModifier;
import com.crud_operation.crud_operation.api.model.Users;
import com.crud_operation.crud_operation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseModifier getUser(@RequestParam Integer id) {
        Optional<List<Users>> user = userService.getUserById(id);
        ResponseModifier response = new ResponseModifier();
        response.setData(user);
        response.setMessage("user retrieved successfully");
        return response;
    }

    @GetMapping("/allUsers")
    public ResponseModifier getAllUser() {
        Optional<List<Users>> users = userService.getUsers();
        ResponseModifier response = new ResponseModifier();
        response.setData(users);
        response.setMessage("All users retrieved successfully");
        return response;
    }
}
