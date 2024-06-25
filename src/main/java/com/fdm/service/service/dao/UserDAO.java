package com.fdm.service.service.dao;

import com.fdm.service.repository.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    UserEntity save(UserEntity userEntity);

    List<UserEntity> findAll();

    Optional<UserEntity> findById(Integer userId);

    void deleteById(Integer userId);
}
