package dxc.ocbc.adapters.data;

import dxc.ocbc.dto.UserDto;

import java.util.List;

public interface UserData {
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUser();
}
