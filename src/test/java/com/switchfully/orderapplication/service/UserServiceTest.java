package com.switchfully.orderapplication.service;

import com.switchfully.orderapplication.domain.adress.Address;
import com.switchfully.orderapplication.domain.email.Email;
import com.switchfully.orderapplication.domain.phoneNumber.PhoneNumber;
import com.switchfully.orderapplication.domain.user.User;
import com.switchfully.orderapplication.repository.UserRepository;
import com.switchfully.orderapplication.service.dto.user.CreateUserDto;
import com.switchfully.orderapplication.service.dto.user.UserDto;
import com.switchfully.orderapplication.service.mapper.UserMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    CreateUserDto userMichelle;
    User userBill;

    @BeforeEach
    void initUsers() {
        userMichelle = new CreateUserDto("Michelle", "Obama", new Email("michelle", "obama.com"), new Address("President Avenue", "156", "4598", "Washington DC"), new PhoneNumber("1", "55598769"), "michelle", "obama", User.Role.CUSTOMER);
        userBill = new User("Bill", "Clinton", new Email("bill", "clinton.com"), new Address("Congress str.", "125", "459873", "Washington DC"), new PhoneNumber("1", "456987521"), "bill", "billbill", User.Role.ADMIN);
    }


    @Test
    void givenAUserDto_whenCreateUser_thenAddUserToUserRepository() {
        userService.createUser(userMichelle);

        Assertions.assertThat(userRepository.getAll().contains(userMichelle));
    }

    @Test
    void givenASingleUserInRepository_whenGetAll_thenReturnUser() {


    }

    @Test
    void getUserById() {

    }

    @Test
    void getUserByUsername() {
    }

    @Test
    void userAlreadyExists() {
    }
}