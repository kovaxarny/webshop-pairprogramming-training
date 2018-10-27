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

import javax.validation.constraints.Email;
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
    public void createNewUserAccount(User user) throws RuntimeException{
        validateUser(user);
        isUsernameTaken(user.getUsername());
        isEmailTaken(user.getEmail());
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

    private void isUsernameTaken(String username) throws RuntimeException{
        if (userRepository.findByUsername(username).isPresent()) {
            throw new AccountWithUsernameAlreadyExistsException("Username is already in use.");
        }
    }

    private void isEmailTaken(@Email String email) throws RuntimeException{
        if (userRepository.findByEmail(email).isPresent()) {
            throw new AccountWithEmailAlreadyExistsException("Email is already in use.");
        }
    }

    private void validateUser(User user) throws RuntimeException{
        try{
            UserValidator.isValidUserAccount(user);
        }catch (Exception e){
            LOGGER.error(e);
            throw e;
        }
    }
}
