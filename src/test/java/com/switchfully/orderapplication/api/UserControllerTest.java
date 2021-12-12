package com.switchfully.orderapplication.api;

import com.switchfully.orderapplication.domain.adress.Address;
import com.switchfully.orderapplication.domain.email.Email;
import com.switchfully.orderapplication.domain.phoneNumber.PhoneNumber;
import com.switchfully.orderapplication.domain.user.User;
import com.switchfully.orderapplication.repository.UserRepository;
import com.switchfully.orderapplication.service.SecurityService;
import com.switchfully.orderapplication.service.dto.user.CreateUserDto;
import com.switchfully.orderapplication.service.dto.user.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserControllerTest {

    @Autowired
    UserController userController;
    @Autowired
    SecurityService securityService;
    @Autowired
    UserRepository userRepository;

    @BeforeEach
     void setup() {
        User userAdmin = new User("first", "admin", new Email("admin", "admin.com"), new Address("street", "number", "1111", "Brussels"), new PhoneNumber("32", "456987523"), "admin", "admin", User.Role.ADMIN);
        userRepository.save(userAdmin);
    }

    @Test
    void givenAUser_whenRegisterAUserDto_thenAddNewUserToUserRepository() {

     UserDto actual = userController.registerUser(new CreateUserDto("Barack", "Obama", new Email("obama", "obama.com"), new Address("President avenue", "456", "9862", "Washington DC"), new PhoneNumber("1", "456987"), "obama", "president", User.Role.ADMIN));

     assert userRepository.getAllEmailAddress().contains(actual.getEmail());
    }

}
