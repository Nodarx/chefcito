package com.chefcito.backend;

import com.chefcito.entities.User;
import com.chefcito.repositories.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class User_Controller {

    @Autowired
    User_Repository user_repository;

    @GetMapping("/logging/{nick}/{pass}")
    public boolean isLog(@PathVariable String nick, @PathVariable String pass){
        User user = user_repository.findByNick(nick);

        if(user != null && user.getPassword().equals(pass))
            return true;

        return false;
    }

    @PostMapping("/register")
    public boolean register(@RequestBody User user){
            user_repository.save(user);
            return true;
    }

}
