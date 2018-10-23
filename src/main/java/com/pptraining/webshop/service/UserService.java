package com.pptraining.webshop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The UserService interface contains the methods which are
 * necessary to manage {@link UserDO} objects.
 *
 * @version 1.0
 */
public interface UserService {

    /**
     * This method is used to create a new {@link UserDO} object.
     * @param userDO This is a new {@link UserDO} object.
     */
    void createUser(UserDO userDO);

    /**
     * This method is used to find a {@link UserDO} in the database
     * by the id.
     * @param id This is an id.
     * @return UserDO This is the found {@link UserDO} object.
     */
    UserDO findUserById(Long id);

    /**
     * This method is used to find a {@link UserDO} in the database
     * by the username.
     * @param username This is a username.
     * @return UserDO This is the found {@link UserDO} object.
     */
    UserDO findUserByUsername(String username);

    /**
     * This method is used to find all the {@link UserDO} objects
     * in the database.
     * @param pageable This is a {@link Pageable} object.
     * @return Page This is a collection of the found {@link UserDO} objects.
     */
    Page<UserDO> findAllUser(Pageable pageable);
}
