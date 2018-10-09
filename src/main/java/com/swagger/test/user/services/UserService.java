package com.swagger.test.user.services;

import com.swagger.test.swagger.models.User;
import com.swagger.test.user.entities.UserEntity;
import com.swagger.test.utilities.objectmapper.DatabaseObjectMapper;
import com.swagger.test.user.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    DatabaseObjectMapper dom;

    public User getUser(long id) throws IllegalAccessException {
        System.out.println("2.User Service getUser Called!");
        Optional<UserEntity> u = userRepo.findById(id);
        if(u.isPresent()) {
            User user = dom.dbToApi(new User(), u.get());
            return user;
        }
        return null;
    }

    public boolean addUser(User user) throws IllegalAccessException{
        UserEntity userEntity = dom.apiToDb(user,new UserEntity());
        System.out.println(userRepo.save(userEntity));
        return true;
    }

}
