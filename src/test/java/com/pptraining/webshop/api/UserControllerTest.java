package com.pptraining.webshop.api;

import com.pptraining.webshop.service.UserServiceImpl;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//TODO Olvass utana ezeknek az annotacioknak.
@RunWith(SpringRunner.class)
@EnableWebMvc
@EnableSpringDataWebSupport
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    private JSONObject userDOJSONObject;
    private JSONObject addressJSONObject;

    @Before
    public void setUp() throws Exception {
        addressJSONObject = new JSONObject();
        addressJSONObject.put("zipCode","4326");
        addressJSONObject.put("country","Hungary");
        addressJSONObject.put("city","Kiskunhalas");
        addressJSONObject.put("street","Hajas utca");
        addressJSONObject.put("houseNumber","48");
        userDOJSONObject = new JSONObject();
        userDOJSONObject.put("username","kovaxarny");
        userDOJSONObject.put("firstName","Kovacs");
        userDOJSONObject.put("lastName","Szilveszter");
        userDOJSONObject.put("email","kovaxarny@yahoo.com");
        userDOJSONObject.put("phoneNumber","0764258245");
        userDOJSONObject.put("address",addressJSONObject);
    }

    @Test
    public void createUserWithPostMethodAPICall() throws Exception {
        this.mockMvc.perform(post("/api/v1/user/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userDOJSONObject.toString()))
                .andExpect(status().isOk());
    }

}