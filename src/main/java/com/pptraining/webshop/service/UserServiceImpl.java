package com.pptraining.webshop.service;

import com.pptraining.webshop.WebshopApplication;
import com.pptraining.webshop.service.exception.AccountWithEmailAlreadyExistsException;
import com.pptraining.webshop.service.exception.AccountWithUsernameAlreadyExistsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private static final Logger LOGGER = LogManager.getLogger(WebshopApplication.class);


    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createNewUserAccount(User user){
        try{
            UserValidator.isValidUserAccount(user);
        }catch (Exception e){
            LOGGER.error(e);
            throw e;
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new AccountWithEmailAlreadyExistsException("Email is already in use.");
        }

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new AccountWithUsernameAlreadyExistsException("Username is already in use.");
        }
        user.setCreationDate(LocalDateTime.now());
        userRepository.save(user);
    }

    //TODO Check with java9 ifPresentOrElse
    @Override
    public User findUserById(Long id) {
        Optional<User> searchResult = userRepository.findById(id);
        if (searchResult.isPresent()) {
            return searchResult.get();
        } else {
            return null;
        }
    }

    @Override
    public User findUserByUsername(String username) {
        Optional<User> searchResult = userRepository.findByUsername(username);
        if (searchResult.isPresent()) {
            return searchResult.get();
        } else {
            return null;
        }
    }

    @Override
    public Page<User> findAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
