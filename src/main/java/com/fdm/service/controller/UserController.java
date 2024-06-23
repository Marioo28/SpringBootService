package com.fdm.service.controller;

import com.fdm.service.controller.dto.user.*;
import com.fdm.service.service.UserService;
import com.fdm.service.service.mapper.UserMapper;
import com.fdm.service.service.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(path = "/create")
    public CreateUserRespDTO createUser(@RequestBody CreateUserReqDTO createUserReqDTO){
        User userModel = userMapper.createUserReqDtoToUser(createUserReqDTO);
        return userService.createUser(userModel);
    }

    @GetMapping(path = "/all")
    public List<ViewUserRespDTO> getAllUser(){
        return userService.getAllUser();
    }



    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        userService.deleteUserById(userId);
        }

        @PutMapping(path = "/{userId}")
        public UpdateUserRespDTO updateUser(@PathVariable Integer userId, @RequestBody UpdateUserReqDTO updateUserReqDTO){

        User userModel = userMapper.updateUserReqDtoToUser(updateUserReqDTO);
        return userService.updateUser(userId, userModel);
        }
    }

