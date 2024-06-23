package com.fdm.service.service;

import com.fdm.service.controller.dto.user.CreateUserRespDTO;
import com.fdm.service.controller.dto.user.DeleteUserReqDTO;
import com.fdm.service.controller.dto.user.UpdateUserRespDTO;
import com.fdm.service.controller.dto.user.ViewUserRespDTO;
import com.fdm.service.repository.UserRepository;
import com.fdm.service.repository.entity.UserEntity;
import com.fdm.service.service.mapper.UserMapper;
import com.fdm.service.service.model.User;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public CreateUserRespDTO createUser(User userModel){
        UserEntity userEntity = userMapper.userModelToUserEntity(userModel);
        UserEntity userEntitySeved = userRepository.save(userEntity);
        User user = userMapper.userEtityToUserModel(userEntitySeved);

        return userMapper.userModelToCreateUserRespDTO(user);
    }


    public List<ViewUserRespDTO> getAllUser(){
        List<UserEntity> userEntityList = userRepository.findAll();
        List<User> userModelList = new ArrayList<>();

        for(UserEntity userEntity: userEntityList){
            User u = userMapper.userEtityToUserModel(userEntity);
            userModelList.add(u);
        }

        List<ViewUserRespDTO> viewUserRespDTOList = new ArrayList<>();

        for(User u : userModelList){
            ViewUserRespDTO viewUserRespDTO = userMapper.userModelToviewUserRespDTO(u);
            viewUserRespDTOList.add(viewUserRespDTO);
        }
        return viewUserRespDTOList;

    }
    public UpdateUserRespDTO updateUser(Integer userId, User userModel){
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        UserEntity userEntity = userEntityOptional.get();
        userEntity = userMapper.userModelToUserEntity(userModel);
        userEntity.setId(userId);
        UserEntity userEntityUpdate = userRepository.save(userEntity);
        User user = userMapper.userEtityToUserModel(userEntityUpdate);
        return userMapper.userModelToUpdateUserRespDTO(user);
    }

    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
