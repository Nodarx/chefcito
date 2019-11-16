package com.chefcito.repositories;

import com.chefcito.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repository extends JpaRepository<User, Integer> {
    User findByNick(String nick);
}
