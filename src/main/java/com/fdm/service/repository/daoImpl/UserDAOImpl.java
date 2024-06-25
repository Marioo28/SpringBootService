package com.fdm.service.repository.daoImpl;

import com.fdm.service.repository.UserRepository;
import com.fdm.service.repository.entity.UserEntity;
import com.fdm.service.service.dao.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    private final UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
