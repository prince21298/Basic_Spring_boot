package com.crud_operation.crud_operation.services;

import com.crud_operation.crud_operation.api.model.Users;
import com.crud_operation.crud_operation.api.response.ErrorModifier;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private List<Users> usersList;

    public UserService() {
        usersList = new ArrayList<>();
        Users user = new Users(2, "prince", 24, "prince@gmail.com");
        Users user1 = new Users(9, "prince912", 25, "prince912@gmail.com");
        Users user2 = new Users(8, "prince786", 18, "prince786@gmail.com");
        Users user3 = new Users(54, "prince765", 29, "prince765@gmail.com");
        Users user4 = new Users(92, "prince456", 31, "prince456@gmail.com");
        Users user5 = new Users(21, "prince123", 42, "prince123@gmail.com");
        usersList.addAll(Arrays.asList(user, user1, user2, user3, user4, user5));
    }

    public Optional<List<Users>> getUserById(Integer id) throws ErrorModifier {
        Optional<List<Users>> users = null;
        for (Users user : usersList) {
            if (id == user.getId()) {
                users = Optional.of(Collections.singletonList(user));
                return users;
            }
        }
        throw new ErrorModifier("No user found with ID: " + id);
    }

    public Optional<List<Users>> getUsers() {
        return Optional.ofNullable(usersList);
    }

    public Optional<List<Users>> addUser(Users userData) throws ErrorModifier {
        usersList.add(userData);
        return Optional.of(Collections.singletonList(userData));
    }

    public Optional<List<Users>> updateUser(Users dataPayload, int id) throws ErrorModifier {
        for (Users user : usersList) {
            if (id == user.getId()) {
                user.setAge(dataPayload.getAge());
                user.setEmail(dataPayload.getEmail());
                user.setName(dataPayload.getName());
                return Optional.of(Collections.singletonList(user));
            }
        }
        throw new ErrorModifier("No user found with ID: " + id);
    }

    @SuppressWarnings("unused")
    public Optional<List<Users>> deleteUser(int id) throws ErrorModifier {
        int index = 0;
        for (Users user : usersList) {
            if (id == user.getId()) {
                usersList.remove(index);
                return Optional.of(Collections.singletonList(user));
            }
            index++;
        }
        throw new ErrorModifier("No user found with ID: " + id);
    }
}
