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
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    UserService userService;

    private UserRepository userRepositoryMock;
    private UserMapper userMapperMock;

    CreateUserDto userMichelle;
    User userBill;

    @BeforeEach
    void setup() {
        userMichelle = new CreateUserDto("Michelle", "Obama", new Email("michelle", "obama.com"), new Address("President Avenue", "156", "4598", "Washington DC"), new PhoneNumber("1", "55598769"), "michelle", "obama", User.Role.CUSTOMER);
        userBill = new User("Bill", "Clinton", new Email("bill", "clinton.com"), new Address("Congress str.", "125", "459873", "Washington DC"), new PhoneNumber("1", "456987521"), "bill", "billbill", User.Role.ADMIN);
        userRepositoryMock = Mockito.mock(UserRepository.class);
        userMapperMock = Mockito.mock(UserMapper.class);
        userService = new UserService(userRepositoryMock, userMapperMock);
    }


    @Test
    void givenACreateUserDto_whenCreateUser_thenAddUserToUserRepository() {
       User userFromMichelle = new User(userMichelle.getFirstName(), userMichelle.getLastName(), userMichelle.getEmail(), userMichelle.getAddress(), userMichelle.getPhoneNumber(), userMichelle.getUsername(), userMichelle.getPassword(), userMichelle.getUserRole());
       UserDto userDtoMichelle = new UserDto().setId(userFromMichelle.getId()).setFirstName(userFromMichelle.getFirstName()).setLastName(userFromMichelle.getLastName()).setAddress(userFromMichelle.getAddress()).setEmail(userFromMichelle.getEmail()).setPhoneNumber(userFromMichelle.getPhoneNumber()).setUsername(userFromMichelle.getUsername()).setPassword(userFromMichelle.getPassword()).setUserRole(userFromMichelle.getUserRole());
       when(userMapperMock.mapFromCreateDtoToUser(userMichelle))
                .thenReturn(userFromMichelle);
        when(userRepositoryMock.save(userFromMichelle)).thenReturn(userFromMichelle);
        when(userMapperMock.mapUserToUserDto(userFromMichelle))
                .thenReturn(userDtoMichelle);
        UserDto result = userService.createUser(userMichelle);

        verify(userMapperMock).mapFromCreateDtoToUser(userMichelle);
        verify(userRepositoryMock).save(userFromMichelle);
        verify(userMapperMock).mapUserToUserDto(userFromMichelle);

        Assertions.assertThat(result).isEqualTo(userDtoMichelle);
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