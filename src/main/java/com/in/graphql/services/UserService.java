package com.in.graphql.services;

import com.in.graphql.entites.User;
import com.in.graphql.helper.ExceptionHelper;
import com.in.graphql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

   // @Autowired
    private UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    //Create User
    public User createUser(User user){
        return userRepo.save(user);
    }

    //getting all User
    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    //getting Single User
    public User getUser(int userId){

        User user= userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
         return user;
    }

    public boolean deleteUser(int userId){
        User user= userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepo.delete(user);
        return true;
    }

}
