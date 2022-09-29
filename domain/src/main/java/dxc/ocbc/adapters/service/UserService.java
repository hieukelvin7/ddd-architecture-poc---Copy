package dxc.ocbc.adapters.service;

import dxc.ocbc.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUser();
}
