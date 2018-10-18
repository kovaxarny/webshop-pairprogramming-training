package com.pptraining.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDO userDO) {
        userRepository.save(userDO);
    }

    //TODO Check with java9 ifPresentOrElse
    @Override
    public UserDO findUserById(Long id) {
        Optional<UserDO> searchResult = userRepository.findById(id);
        if(searchResult.isPresent()){
            return searchResult.get();
        } else {
            return null;
        }
    }

    @Override
    public UserDO findUserByUsername(String username) {
        Optional<UserDO> searchResult = userRepository.findByUsername(username);
        if(searchResult.isPresent()){
            return searchResult.get();
        } else {
            return null;
        }
    }

    @Override
    public Page<UserDO> findAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
