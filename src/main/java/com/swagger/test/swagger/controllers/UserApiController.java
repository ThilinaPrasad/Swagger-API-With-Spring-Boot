package com.swagger.test.swagger.controllers;

import com.swagger.test.swagger.models.Response;
import com.swagger.test.swagger.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swagger.test.user.services.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-10-09T06:12:03.498Z")

@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    UserService userService;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Response> addUser(@ApiParam(value = "User object that needs to be added to the system" ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Response>(objectMapper.readValue("{  \"responseType\" : \"responseType\",  \"message\" : \"message\",  \"responseCode\" : 0}", Response.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Response>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Response>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Response> deleteById(@ApiParam(value = "ID of deleting user",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Response>(objectMapper.readValue("{  \"responseType\" : \"responseType\",  \"message\" : \"message\",  \"responseCode\" : 0}", Response.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Response>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Response>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> getUserById(@ApiParam(value = "ID of deleting user",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        System.out.println("1.Requested");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
            } catch (IllegalAccessError e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Response> updateUser(@ApiParam(value = "User object that needs to be updated in the system" ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Response>(objectMapper.readValue("{  \"responseType\" : \"responseType\",  \"message\" : \"message\",  \"responseCode\" : 0}", Response.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Response>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Response>(HttpStatus.NOT_IMPLEMENTED);
    }

}
