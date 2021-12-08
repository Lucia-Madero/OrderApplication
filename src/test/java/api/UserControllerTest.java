package api;

import com.switchfully.orderapplication.api.UserController;
import com.switchfully.orderapplication.service.SecurityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import com.switchfully.orderapplication.repository.UserRepository;
import com.switchfully.orderapplication.service.UserService;
import com.switchfully.orderapplication.service.dto.user.CreateUserDto;
import com.switchfully.orderapplication.service.mapper.UserMapper;


import java.util.UUID;

@Disabled
public class UserControllerTest {

    private UserController userController;
    private UserRepository userRepository;
    private CreateUserDto createUserDto;
    private UserService userService;
    private UserMapper userMapper;
    private SecurityService securityService;

    @BeforeEach
    void setup() {
        userMapper = new UserMapper();
        userRepository = new UserRepository();
        userService = new UserService(userRepository, userMapper);
        userController = new UserController(userService, securityService);
        createUserDto = new CreateUserDto();
    }

    @Test
    void givenUser_whenRegisterAsUser_thenNewUserIsAdded() {

        UUID actual = userController.registerUser(createUserDto).getId();

        Assertions.assertThat(actual).isIn(userRepository.getAll());
    }
}
