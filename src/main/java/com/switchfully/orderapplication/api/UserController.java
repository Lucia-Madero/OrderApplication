package com.switchfully.orderapplication.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.switchfully.orderapplication.service.UserService;
import com.switchfully.orderapplication.service.dto.CreateUserDto;
import com.switchfully.orderapplication.service.dto.UserDto;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userservice;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);


    public UserController(UserService userservice) {
        this.userservice = userservice;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus (HttpStatus.CREATED)
    public UserDto registerUser (@RequestBody CreateUserDto userToCreate) {
        logger.info("Handle request to create a user in application");
        return userservice.createUser(userToCreate);
    }
}
