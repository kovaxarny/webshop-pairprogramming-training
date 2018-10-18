package com.pptraining.webshop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    void createUser(UserDO userDO);
    UserDO findUserById(Long id);
    UserDO findUserByUsername(String username);
    Page<UserDO> findAllUser(Pageable pageable);
}
