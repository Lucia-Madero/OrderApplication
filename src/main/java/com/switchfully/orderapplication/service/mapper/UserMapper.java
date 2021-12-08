package com.switchfully.orderapplication.service.mapper;

import com.switchfully.orderapplication.domain.user.User;
import com.switchfully.orderapplication.service.dto.user.CreateUserDto;
import com.switchfully.orderapplication.service.dto.user.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapFromCreateDtoToUser(CreateUserDto userToCreate) {
        return new User(userToCreate.getFirstName(),
                userToCreate.getLastName(),
                userToCreate.getEmail(),
                userToCreate.getAddress(),
                userToCreate.getPhoneNumber(),
                userToCreate.getUsername(),
                userToCreate.getPassword(),
                userToCreate.getUserRole());

    }

    public UserDto mapUserToUserDto(User savedUser) {
        return new UserDto()
                .setId(savedUser.getId())
                .setFirstName(savedUser.getFirstName())
                .setLastName(savedUser.getLastName())
                .setEmail(savedUser.getEmail())
                .setAddress(savedUser.getAddress())
                .setPhoneNumber(savedUser.getPhoneNumber())
                .setUsername(savedUser.getUsername())
                .setPassword(savedUser.getPassword())
                .setUserRole(savedUser.getUserRole());

    }
}
