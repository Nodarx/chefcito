package com.chefcito.backend;

import com.chefcito.entities.KP_ID;
import com.chefcito.entities.Keep;
import com.chefcito.entities.Recipe;
import com.chefcito.entities.User;
import com.chefcito.repositories.Keep_Repository;
import com.chefcito.repositories.Recipe_Repository;
import com.chefcito.repositories.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Keep_Controller {

    @Autowired
    Keep_Repository keep_repository;

    @Autowired
    User_Repository user_repository;

    @Autowired
    Recipe_Repository recipe_repository;

    @GetMapping("/keep/{nick}")
    public List<Recipe> getKeeps(@PathVariable String nick){
        List<Recipe> recipes = new ArrayList<>();
        List<Keep> keeps = keep_repository.findAllByIdUser(user_repository.findByNick(nick));

        for (int i = 0; i < keeps.size(); i++) {
            recipes.add(keeps.get(i).geRecipe());
        }

        return recipes;
    }

    @PostMapping("/keep/{nick}/{title}")
    public boolean addKeep(@PathVariable String nick, @PathVariable String title){
        User user = user_repository.findByNick(nick);
        Recipe recipe = recipe_repository.findByTitle(title);

        if(user != null && recipe != null){
            keep_repository.save(new Keep(user,recipe));
            return true;
        }

        return false;
    }

    @DeleteMapping("/keep/{nick}/{title}")
    public void deleteKeep(@PathVariable String nick, @PathVariable String title){
        keep_repository.delete(keep_repository.getOne(new KP_ID(user_repository.findByNick(nick),
                recipe_repository.findByTitle(title))));
    }

}
