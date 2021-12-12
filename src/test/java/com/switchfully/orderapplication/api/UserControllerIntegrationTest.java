package com.switchfully.orderapplication.api;

import com.switchfully.orderapplication.domain.adress.Address;
import com.switchfully.orderapplication.domain.email.Email;
import com.switchfully.orderapplication.domain.phoneNumber.PhoneNumber;
import com.switchfully.orderapplication.domain.user.User;
import com.switchfully.orderapplication.service.UserService;
import com.switchfully.orderapplication.service.dto.user.CreateUserDto;
import com.switchfully.orderapplication.service.dto.user.UserDto;
import com.switchfully.orderapplication.service.mapper.UserMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserControllerIntegrationTest {

    @Autowired
    private UserController userController;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

//    @Test
//    void registerUser() {
//        userMapper.mapFromCreateDtoToUser(userController.registerUser(new CreateUserDto("Marge", "Simpson", new Email("marge", "simpson.com"), new Address("Springfield Avenue", "306", "1598", "Springfield"), new PhoneNumber("32", "123654897"), "marge", "simpson", User.Role.CUSTOMER)));
//
//
//    }

    @Test
    void getAllUsersInApplication() {
    }

    @Test
    void getUserById() {
    }
}