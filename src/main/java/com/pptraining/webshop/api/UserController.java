package com.pptraining.webshop.api;

import com.pptraining.webshop.WebshopApplication;
import com.pptraining.webshop.service.UserDO;
import com.pptraining.webshop.service.UserService;
import com.pptraining.webshop.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * The UserController class contains the methods which allow
 * the clients to manage User data.
 *
 * @version 1.0
 */
@Controller
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(WebshopApplication.class);

    @Autowired
    private final UserService userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * This method is used to create a new User entity and save it
     * to the database.
     *
     * @param userDO This is a new UserDO object.
     * @return ResponseEntity This returns a {@link ResponseEntity} with a status code.
     */
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody UserDO userDO){
        userService.createUser(userDO);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * This method is used to find a {@link UserDO} in the database by id.
     *
     * @param id This is the id of the user.
     * @return ResponseEntity This returns a {@link ResponseEntity} which contains
     * the found user and a status code.
     */
    //TODO JUnit tests
    @GetMapping(path = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDO> findUserById(@RequestParam Long id){
        return new ResponseEntity<>(userService.findUserById(id),HttpStatus.OK);
    }

    /**
     * This method is used to find a {@link UserDO} in the database by username.
     *
     * @param username This is the username of the user.
     * @return ResponseEntity This returns a {@link ResponseEntity} which contains
     * the found user and a status code.
     */
    @GetMapping(path = "/find/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDO> findUserByUsername(@RequestParam String username){
        return new ResponseEntity<>(userService.findUserByUsername(username),HttpStatus.OK);
    }

    /**
     * This method is used to find all {@link UserDO} object in the database.
     * @param pageable This is a {@link Pageable} object.
     * @return ResponseEntity This returns a {@link ResponseEntity} which contains
     * the found users and a status code.
     */
    @GetMapping(path = "/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<UserDO>> findAllUser(@PageableDefault Pageable pageable){
        return new ResponseEntity<>(userService.findAllUser(pageable),HttpStatus.OK);
    }
}
