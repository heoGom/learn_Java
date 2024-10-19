package org.example.springv3.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.springv3.user.UserController;
import org.example.springv3.user.UserRequest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;
    private ObjectMapper om = new ObjectMapper();

    @Test
    public void join_test() throws Exception {
        // given
        UserRequest.JoinDTO joinDTO = new UserRequest.JoinDTO();
        joinDTO.setUsername("haha");
        joinDTO.setPassword("1234");
        joinDTO.setEmail("haha@nate.com");

        String requestBody = om.writeValueAsString(joinDTO);
        //System.out.println(requestBody);

        // when
        ResultActions actions = mvc.perform(
                post("/join")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
        String responseBody = actions.andReturn().getResponse().getContentAsString();
        //System.out.println(responseBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.id").value(4));
        actions.andExpect(jsonPath("$.body.username").value("haha"));
        actions.andExpect(jsonPath("$.body.email").value("haha@nate.com"));
        actions.andExpect(jsonPath("$.body.profile").isEmpty());
    }

    @Test
    public void login_test() throws Exception {
        // given
        UserRequest.LoginDTO loginDTO = new UserRequest.LoginDTO();
        loginDTO.setUsername("ssar");
        loginDTO.setPassword("1234");

        String requestBody = om.writeValueAsString(loginDTO);
        System.out.println(requestBody);

        // when
        ResultActions actions = mvc.perform(
                post("/login")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
        String responseBody = actions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);

        String responseJwt = actions.andReturn().getResponse().getHeader("Authorization");
        System.out.println(responseJwt);

        // then
        actions.andExpect(header().string("Authorization", Matchers.notNullValue()));
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body").isEmpty());

    }

}
