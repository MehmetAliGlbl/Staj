package com.proje.contractapi.mapper;

import com.proje.contractapi.model.User;
import com.proje.contractapi.rest.dto.UserDto;

public interface UserMapper {

    UserDto toUserDto(User user);
}