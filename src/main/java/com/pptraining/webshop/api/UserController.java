package com.pptraining.webshop.api;

import com.pptraining.webshop.WebshopApplication;
import com.pptraining.webshop.service.User;
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

    //TODO Create new user with admin role
    /**
     * This method is used to create a new User entity and save it
     * to the database.
     *
     * @param user This is a new User object.
     * @return ResponseEntity This returns a {@link ResponseEntity} with a status code.
     */
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNewUserAccount(@RequestBody User user){
        HttpStatus status;
        String message = "";
        try {
            userService.createNewUserAccount(user);
            status = HttpStatus.OK;
        }catch (Exception e){
            message = message + e.getMessage();
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(message,status);
    }

    //TODO secure findUserById for admins
    @GetMapping(path = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findUserById(id),HttpStatus.OK);
    }

    //TODO secure findUserByUsername for admins
    @GetMapping(path = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findUserByUsername(@RequestParam(value = "username") String username){
        return new ResponseEntity<>(userService.findUserByUsername(username),HttpStatus.OK);
    }

    //TODO secure findAllUser for admins
    /**
     * This method is used to find all {@link User} object in the database.
     * @param pageable This is a {@link Pageable} object.
     * @return ResponseEntity This returns a {@link ResponseEntity} which contains
     * the found users and a status code.
     */
    @GetMapping(path = "/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<User>> findAllUser(@PageableDefault Pageable pageable){
        return new ResponseEntity<>(userService.findAllUser(pageable),HttpStatus.OK);
    }

    //Register as guest
    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerAsUser (User user){
        userService.createNewUserAccount(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    //TODO secure admin only
    @PostMapping(path = "/grantadminroleto")
    public ResponseEntity grantAdminRoleTo(@RequestParam(value = "id") Long id){
        //userService.grantAdminRoleTo(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //TODO secure admin only
    @PostMapping(path = "/revokeadminrolefrom")
    public ResponseEntity revokeAdminRoleFrom(@RequestParam(value = "id") Long id){
        //userService.revokeAdminRoleFrom(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path = "/udpateuser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody User user){
        //userService.updateUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
