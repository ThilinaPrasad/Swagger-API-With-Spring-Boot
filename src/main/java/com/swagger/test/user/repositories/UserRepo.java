package com.swagger.test.user.repositories;

import com.swagger.test.swagger.models.db.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel, Long> {
}
