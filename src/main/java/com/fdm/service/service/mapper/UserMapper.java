package com.fdm.service.service.mapper;

import com.fdm.service.controller.dto.user.*;
import com.fdm.service.repository.entity.UserEntity;
import com.fdm.service.service.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User createUserReqDtoToUser(CreateUserReqDTO createUserReqDTO){
        return User.builder()
                .username(createUserReqDTO.getUsername())
                .age(createUserReqDTO.getAge())
                .type(createUserReqDTO.getType())
                .firstName(createUserReqDTO.getFirstName())
                .lastName(createUserReqDTO.getLastName())
                .password(createUserReqDTO.getPassword())
                .build();
    }

    public CreateUserRespDTO userModelToCreateUserRespDTO(User userModel){
        return CreateUserRespDTO.builder()
                .username(userModel.getUsername())
                .age(userModel.getAge())
                .type(userModel.getType())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .password(userModel.getPassword())
                .build();
    }

    public UserEntity userModelToUserEntity(User userModel){
        return UserEntity.builder()
                .username(userModel.getUsername())
                .age(userModel.getAge())
                .type(userModel.getType())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .password(userModel.getPassword())
                .build();
    }

    public User userEtityToUserModel(UserEntity userEntity){
        return User.builder()
                .username(userEntity.getUsername())
                .age(userEntity.getAge())
                .type(userEntity.getType())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .password(userEntity.getPassword())
                .build();
    }

    public ViewUserRespDTO userModelToviewUserRespDTO(User userModel){
        return ViewUserRespDTO.builder()
                .username(userModel.getUsername())
                .age(userModel.getAge())
                .type(userModel.getType())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .password(userModel.getPassword())
                .build();
    }


    public DeleteUserReqDTO deleteUserReqDTO(Integer id){
        return deleteUserReqDTO(id);
    }

    public UpdateUserRespDTO userModelToUpdateUserRespDTO(User userModel){
        return UpdateUserRespDTO.builder()
                .username(userModel.getUsername())
                .age(userModel.getAge())
                .type(userModel.getType())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .password(userModel.getPassword())
                .build();
    }
    public User updateUserReqDtoToUser(UpdateUserReqDTO updateUserReqDTO){
        return User.builder()
                .username(updateUserReqDTO.getUsername())
                .age(updateUserReqDTO.getAge())
                .type(updateUserReqDTO.getType())
                .firstName(updateUserReqDTO.getFirstName())
                .lastName(updateUserReqDTO.getLastName())
                .password(updateUserReqDTO.getPassword())
                .build();
    }


}
