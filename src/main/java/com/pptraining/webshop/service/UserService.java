package com.pptraining.webshop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The UserService interface contains the methods which are
 * necessary to manage {@link User} objects.
 *
 * @version 1.0
 */
public interface UserService {

    /**
     * This method is used to create a new {@link User} object.
     * @param user This is a new {@link User} object.
     */
    void createNewUserAccount(User user);

    /**
     * This method is used to find a {@link User} in the database
     * by the id.
     * @param id This is an id.
     * @return User This is the found {@link User} object.
     */
    User findUserById(Long id);

    /**
     * This method is used to find a {@link User} in the database
     * by the username.
     * @param username This is a username.
     * @return User This is the found {@link User} object.
     */
    User findUserByUsername(String username);

    /**
     * This method is used to find all the {@link User} objects
     * in the database.
     * @param pageable This is a {@link Pageable} object.
     * @return Page This is a collection of the found {@link User} objects.
     */
    Page<User> findAllUser(Pageable pageable);
}
