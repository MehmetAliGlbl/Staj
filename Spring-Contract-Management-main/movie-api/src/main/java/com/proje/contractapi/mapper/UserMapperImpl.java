package com.proje.contractapi.mapper;

import org.springframework.stereotype.Service;

import com.proje.contractapi.model.User;
import com.proje.contractapi.rest.dto.UserDto;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(user.getId(), user.getUsername(), user.getName(), user.getEmail(), user.getRole());
    }
}
