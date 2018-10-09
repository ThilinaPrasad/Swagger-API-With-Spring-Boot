package com.swagger.test.user.services;

import com.swagger.test.swagger.models.User;
import com.swagger.test.user.entities.UserEntity;
import com.swagger.test.utilities.DatabaseObjectMapper;
import com.swagger.test.user.repositories.UserRepo;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    DatabaseObjectMapper dom;

    // user get method
    public User getUser(long id) throws IllegalAccessException {
        System.out.println("2.User Service getUser Called!");
        Optional<UserEntity> u = userRepo.findById(id);
        if(u.isPresent()) {
            User user = dom.dbToApi(new User(), u.get());
            return user;
        }
        return null;
    }

    // user add method
    public boolean addUser(User user) throws IllegalAccessException{
        UserEntity userEntity = dom.apiToDb(user,new UserEntity());
        try {
            userRepo.save(userEntity);
            return true;
        }catch (HibernateException e){
            return false;
        }
    }

    // user update method
    public User updateUser(User user) throws  IllegalAccessException{
        UserEntity userEntity = dom.apiToDb(user,new UserEntity());
        if(user.getId() != null){
            try {
                return dom.dbToApi(new User(),userRepo.save(userEntity));
            }catch (HibernateException e){
                return null;
            }
        }
        return null;
    }

    // user deletion method
    public boolean deleteUser(long id){
        try {
            userRepo.deleteById(id);
            return true;
        }catch (HibernateException e){
            return false;
        }
    }

}
