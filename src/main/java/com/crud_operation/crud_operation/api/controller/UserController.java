package com.crud_operation.crud_operation.api.controller;

import com.crud_operation.crud_operation.api.response.ErrorModifier;
import com.crud_operation.crud_operation.api.response.ResponseModifier;
import com.crud_operation.crud_operation.api.model.Users;
import com.crud_operation.crud_operation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseModifier getUser(@RequestParam Integer id) throws ErrorModifier {
        try {
            Optional<List<Users>> user = userService.getUserById(id);
            ResponseModifier response = new ResponseModifier();
            response.setData(user);
            response.setMessage("user retrieved successfully");
            return response;
        } catch (ErrorModifier error) {
            ResponseModifier errorResponse = new ResponseModifier();
            errorResponse.setData(null);
            errorResponse.setSuccess(false);
            errorResponse.setMessage(error.getMessage());
            return errorResponse;
        }

    }

    @GetMapping("/allUsers")
    public ResponseModifier getAllUser() {
        Optional<List<Users>> users = userService.getUsers();
        ResponseModifier response = new ResponseModifier();
        response.setData(users);
        response.setMessage("All users retrieved successfully");
        return response;
    }

    @PostMapping(path = "/addUser", produces = "application/schema+json")
    public ResponseModifier addUser(@RequestBody Users dataPayload) throws ErrorModifier {
        try {
            Optional<List<Users>> users = userService.addUser(dataPayload);
            ResponseModifier response = new ResponseModifier();
            response.setData(users);
            response.setMessage("User added successfully");
            return response;
        } catch (ErrorModifier error) {
            ResponseModifier errorResponse = new ResponseModifier();
            errorResponse.setData(null);
            errorResponse.setSuccess(false);
            errorResponse.setMessage(error.getMessage());
            return errorResponse;
        }
    }

    @PostMapping(path = "/update/{id}", produces = "application/json")
    public ResponseModifier updateUser(@RequestBody Users dataPayload, @PathVariable int id) throws ErrorModifier {
        try {
            Optional<List<Users>> users = userService.updateUser(dataPayload, id);
            ResponseModifier response = new ResponseModifier();
            response.setData(users);
            response.setMessage("User updated successfully");
            return response;
        } catch (ErrorModifier e) {
            ResponseModifier errorResponse = new ResponseModifier();
            errorResponse.setData(null);
            errorResponse.setSuccess(false);
            errorResponse.setMessage(e.getMessage());
            return errorResponse;
        }
    }

    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public ResponseModifier deleteUser(@PathVariable int id) throws ErrorModifier {
        try {
            Optional<List<Users>> users = userService.deleteUser(id);
            ResponseModifier response = new ResponseModifier();
            response.setData(users);
            response.setMessage("User deleteed successfully");
            return response;
        } catch (ErrorModifier e) {
            ResponseModifier errorResponse = new ResponseModifier();
            errorResponse.setData(null);
            errorResponse.setSuccess(false);
            errorResponse.setMessage(e.getMessage());
            return errorResponse;
        }
    }
}
