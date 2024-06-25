package com.fdm.service.service;

import com.fdm.service.controller.dto.user.CreateUserRespDTO;
import com.fdm.service.controller.dto.user.GetUserRespDTO;
import com.fdm.service.controller.dto.user.UpdateUserRespDTO;
import com.fdm.service.controller.dto.user.ViewUserRespDTO;
import com.fdm.service.service.exceptions.user.UserAlreadyExistsException;
import com.fdm.service.service.exceptions.user.UserNotFoundException;
import com.fdm.service.repository.entity.UserEntity;
import com.fdm.service.service.dao.UserDAO;
import com.fdm.service.service.mapper.UserMapper;
import com.fdm.service.service.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final UserMapper userMapper;

    public UserService(UserDAO userDAO, UserMapper userMapper) {
        this.userDAO = userDAO;
        this.userMapper = userMapper;
    }

    public CreateUserRespDTO createUser(User userModel) {
        checkForDuplicate(userModel);
        UserEntity userEntity = userMapper.userModelToUserEntity(userModel);
        UserEntity userEntitySeved = userDAO.save(userEntity);
        User user = userMapper.userEtityToUserModel(userEntitySeved);

        return userMapper.userModelToCreateUserRespDTO(user);
    }


    public List<ViewUserRespDTO> getAllUser() {
        List<UserEntity> userEntityList = userDAO.findAll();
        List<User> userModelList = new ArrayList<>();

        for (UserEntity userEntity : userEntityList) {
            User u = userMapper.userEtityToUserModel(userEntity);
            userModelList.add(u);
        }

        List<ViewUserRespDTO> viewUserRespDTOList = new ArrayList<>();

        for (User u : userModelList) {
            ViewUserRespDTO viewUserRespDTO = userMapper.userModelToviewUserRespDTO(u);
            viewUserRespDTOList.add(viewUserRespDTO);
        }
        return viewUserRespDTOList;
    }

    public UpdateUserRespDTO updateUser(Integer userId, User userModel) {
        checkForDuplicate(userModel);
        Optional<UserEntity> userEntityOptional = userDAO.findById(userId);
        UserEntity userEntity = userEntityOptional.get();
        userEntity = userMapper.userModelToUserEntity(userModel);
        userEntity.setId(userId);
        UserEntity userEntityUpdate = userDAO.save(userEntity);
        User user = userMapper.userEtityToUserModel(userEntityUpdate);
        return userMapper.userModelToUpdateUserRespDTO(user);
    }

    public void deleteUserById(Integer userId) {
        UserEntity userEntity = userDAO.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
        userDAO.deleteById(userId);
    }

    public GetUserRespDTO getUserById(int userId) {
        UserEntity userEntity = userDAO.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));

        User userModel = userMapper.userEtityToUserModel(userEntity);
        return userMapper.userModelToGetUserRespDTO(userModel);
    }

    private void checkForDuplicate(User userModel) {
        List<UserEntity> usersEntityListFromDB = userDAO.findAll();
        for (UserEntity u : usersEntityListFromDB) {
            if (u.getUsername().equalsIgnoreCase(userModel.getUsername())) {
                throw new UserAlreadyExistsException("Username-ul: " + userModel.getUsername() + " exista in DB!");
            }
        }
    }

}
