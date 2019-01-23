package com.test.testCrud.controller;

import com.test.testCrud.dao.UserDAO;
import com.test.testCrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @CrossOrigin
    @RequestMapping(
            path = "login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> login(@RequestParam("name") String name,
                                        @RequestParam("password") String password) {
        if (name.length() < 1) {
            return ResponseEntity.badRequest()
                    .body("Too short name, sorry :(");
        }
        if (name.length() > 20) {
            return ResponseEntity.badRequest()
                    .body("Too long name, sorry :(");
        }
        if (userDAO.save(new User(name, password)) != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }



}
