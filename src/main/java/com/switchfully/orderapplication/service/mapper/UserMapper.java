package com.switchfully.orderapplication.service.mapper;

import com.switchfully.orderapplication.domain.User;
import com.switchfully.orderapplication.service.dto.CreateUserDto;
import com.switchfully.orderapplication.service.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapFromCreateDtoToUser(CreateUserDto userToCreate) {
        return new User(userToCreate.getFirstName(),
                userToCreate.getLastName(),
                userToCreate.getEmail(),
                userToCreate.getAddress(),
                userToCreate.getPhoneNumber());

    }

    public UserDto mapUserToUserDto(User savedUser) {
        return new UserDto()
                .setFirstName(savedUser.getFirstName())
                .setLastName(savedUser.getLastName())
                .setEmail(savedUser.getEmail())
                .setAddress(savedUser.getAddress())
                .setPhoneNumber(savedUser.getPhoneNumber());

    }
}
