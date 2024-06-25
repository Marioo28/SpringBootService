package com.fdm.service.controller;

import com.fdm.service.controller.dto.user.*;
import com.fdm.service.service.UserService;
import com.fdm.service.service.mapper.UserMapper;
import com.fdm.service.service.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CreateUserRespDTO> createUser(@RequestBody CreateUserReqDTO createUserReqDTO) {
        User userModel = userMapper.createUserReqDtoToUser(createUserReqDTO);
        CreateUserRespDTO createUserRespDTO = userService.createUser(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserRespDTO);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ViewUserRespDTO>> getAllUser() {
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getAllUser());
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully delete.");
    }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<UpdateUserRespDTO> updateUser(@PathVariable Integer userId, @RequestBody UpdateUserReqDTO updateUserReqDTO) {
        User userModel = userMapper.updateUserReqDtoToUser(updateUserReqDTO);
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.updateUser(userId, userModel));
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<GetUserRespDTO> getUserById(@PathVariable int userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }
}

