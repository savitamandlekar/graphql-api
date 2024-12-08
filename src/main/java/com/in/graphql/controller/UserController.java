package com.in.graphql.controller;

import com.in.graphql.entites.User;
import com.in.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create User API

    @MutationMapping
    public User createUser(@Argument String name,
                           @Argument String phone,
                           @Argument String email,
                           @Argument String password){
        User user=new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }

    //get users

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    //get Single User
    @QueryMapping
    public User getUser(@Argument int userId){
        return  userService.getUser(userId);
    }

    // delete user

 @SchemaMapping(typeName = "Mutation",field = "deleteUser")
    public  boolean deleteUser(@Argument int userId){

        return  userService.deleteUser(userId);

    }
}
