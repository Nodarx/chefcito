package com.chefcito.repositories;

import com.chefcito.entities.KP_ID;
import com.chefcito.entities.Keep;
import com.chefcito.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Keep_Repository extends JpaRepository<Keep, KP_ID> {
    List<Keep> findAllByIdUser(User user);


}
