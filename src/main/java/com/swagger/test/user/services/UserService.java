package com.swagger.test.user.services;

import com.swagger.test.user.models.User;
import com.swagger.test.user.models.db.UserModel;
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
        Optional<UserModel> u = userRepo.findById(id);
        if(u.isPresent()) {
            User user = dom.dbToApi(new User(), u.get());
            return user;
        }
        return null;
    }

    public void addUser(User user) throws IllegalAccessException{
        UserModel userModel = dom.apiToDb(user,new UserModel());
        System.out.println(userRepo.save(userModel));
    }

}
