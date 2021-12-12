package com.switchfully.orderapplication.api;

import com.switchfully.orderapplication.domain.adress.Address;
import com.switchfully.orderapplication.domain.email.Email;
import com.switchfully.orderapplication.domain.phoneNumber.PhoneNumber;
import com.switchfully.orderapplication.domain.user.User;
import com.switchfully.orderapplication.repository.UserRepository;
import com.switchfully.orderapplication.service.SecurityService;
import com.switchfully.orderapplication.service.dto.user.CreateUserDto;
import com.switchfully.orderapplication.service.dto.user.UserDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;


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
    void createUser() {

     UserDto actual = userController.registerUser(new CreateUserDto("Barack", "Obama", new Email("obama", "obama.com"), new Address("President avenue", "456", "9862", "Washington DC"), new PhoneNumber("1", "456987"), "obama", "president", User.Role.ADMIN));

     assert userRepository.getAllEmailAddress().contains(actual.getEmail());
    }
//
//    private UserController userController;
//    private UserRepository userRepository;
//    private CreateUserDto createUserDto;
//    private UserService userServiceMock;
//    private UserMapper userMapper;
//    private SecurityService securityService;
//
//    @BeforeEach
//    void setup() {
//        userMapper = new UserMapper();
//        userRepository = new UserRepository();
//        userServiceMock = Mockito.mock(UserService.class);
//        userController = new UserController(userServiceMock, securityService);
//        createUserDto = new CreateUserDto("Barack", "Obama", new Email("obama", "obama.com"), new Address("President avenue", "456", "9862", "Washington DC"), new PhoneNumber("1", "456987"),"obama", "president", User.Role.ADMIN);
//    }
//
//    @Test
//    void givenUser_whenRegisterAsUser_thenNewUserIsAdded() {
//
//

//        User actualUser  = userMapper.mapFromCreateDtoToUser(createUserDto);
//
//        Mockito.when(userServiceMock.createUser(createUserDto))
//                .thenReturn(new UserDto().setFirstName(createUserDto.getFirstName()).setLastName(createUserDto.getLastName()).setId(actualUser.getId()).setAddress(createUserDto.getAddress()).setEmail(createUserDto.getEmail()).setPhoneNumber(createUserDto.getPhoneNumber()).setUsername(createUserDto.getUsername()).setPassword(createUserDto.getPassword()).setUserRole(createUserDto.getUserRole()));
//
//        userServiceMock.createUser(createUserDto);
//
//       Assertions.assertThat(actualUser).isIn(userRepository.getAll());
//
//    }
}
