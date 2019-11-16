package com.chefcito.repositories;

import com.chefcito.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Ingredient_Repository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findAllByNameContains(String name);
    Ingredient findByName(String name);
}
