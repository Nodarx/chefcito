package com.chefcito.repositories;

import com.chefcito.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Recipe_Repository extends JpaRepository<Recipe, Integer> {
    Recipe findByTitle(String title);
    List<Recipe> findAllByTitleContains(String title);
}
