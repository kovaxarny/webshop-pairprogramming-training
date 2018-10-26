package com.pptraining.webshop.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

//TODO Olvass utana ezeknek az annotacioknak.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserServiceImplTest {

    @Configuration
    static class UserServiceImplTestContextConfiguration {
        @Bean
        public UserRepository userRepository() {
            return mock(UserRepository.class);
        }

        @Bean
        public UserServiceImpl userService() {
            return new UserServiceImpl(userRepository());
        }
    }

    @Autowired
    private UserServiceImpl userService = mock(UserServiceImpl.class, Mockito.RETURNS_DEEP_STUBS);

    @Autowired
    private UserRepository userRepository = mock(UserRepository.class, Mockito.RETURNS_DEEP_STUBS);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createNewUserAccount_FromUserDO_DAOCalled() throws Exception {
        userService.createNewUserAccount(Mockito.mock(User.class));
        verify(userRepository,times(1)).save(Mockito.any(User.class));
    }

    @Test
    public void findUserById_IdAsParam_DAOCalled() throws Exception {
        userService.findUserById(1L);
        verify(userRepository,times(1)).findById(1L);
    }

    @Test
    public void findUserByUsername_StringAsParam_DAOCalled() throws Exception {
        userService.findUserByUsername("RandomString");
        verify(userRepository,times(1)).findByUsername("RandomString");
    }

    @Test
    public void findAllUser_PageableAsParam_DAOCalled() throws Exception {
        userService.findAllUser(Mockito.mock(Pageable.class));
        verify(userRepository,times(1)).findAll(Mockito.any(Pageable.class));
    }
}