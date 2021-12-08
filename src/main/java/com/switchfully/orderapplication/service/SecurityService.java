package com.switchfully.orderapplication.service;

import com.switchfully.orderapplication.api.UserController;
import com.switchfully.orderapplication.domain.exception.UnknownUserException;
import com.switchfully.orderapplication.domain.exception.UserNotAuthorizedException;
import com.switchfully.orderapplication.domain.exception.WrongPasswordException;
import com.switchfully.orderapplication.domain.feature.Feature;
import com.switchfully.orderapplication.domain.user.User;
import com.switchfully.orderapplication.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Base64;


@Service
public class SecurityService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(SecurityService.class);

    public SecurityService(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public void validateAccess (String authorization, Feature feature){
        String decodeUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodeUsernameAndPassword.substring(0, decodeUsernameAndPassword.indexOf(":"));
        String password = decodeUsernameAndPassword.substring(decodeUsernameAndPassword.indexOf(":") + 1);
        User user = userService.getUserByUsername(username);

        if(user == null) {
            logger.error("UnknownUser " + username);
            throw new UnknownUserException();
        }
        if(user.getPassword().equals(password)) {
            throw new WrongPasswordException("Please enter a valid password");
        }

        if(!user.hasAccessTo(feature)){
            logger.error("User " + user.getEmail() + " does not has access to " + feature);
            throw new UserNotAuthorizedException("You do not have access this operation");
        }
    }
}
