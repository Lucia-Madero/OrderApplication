package com.switchfully.orderapplication.api;

import com.switchfully.orderapplication.domain.feature.Feature;
import com.switchfully.orderapplication.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.switchfully.orderapplication.service.UserService;
import com.switchfully.orderapplication.service.dto.user.CreateUserDto;
import com.switchfully.orderapplication.service.dto.user.UserDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userservice;
    private final SecurityService securityService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);


    public UserController(UserService userservice, SecurityService securityService) {
        this.userservice = userservice;
        this.securityService = securityService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus (HttpStatus.CREATED)
    public UserDto registerUser (@RequestBody CreateUserDto userToCreate) {
        logger.info("Handle request to create a user in application");
        return userservice.createUser(userToCreate);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsersInApplication(@RequestHeader String authorization) {
        securityService.validateAccess(authorization, Feature.VIEW_ALL_CUSTOMERS);
        return userservice.getAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable ("id") UUID id, @RequestHeader String authorization) {
        securityService.validateAccess(authorization, Feature.VIEW_SINGLE_CUSTOMER);
        return userservice.getUserById(id);
    }
}
