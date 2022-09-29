package dxc.ocbc.service;

import dxc.ocbc.dto.UserDto;
import dxc.ocbc.adapters.service.UserService;
import dxc.ocbc.adapters.data.UserData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserData userData;

    @Autowired
    public UserServiceImpl(UserData userData) {
        this.userData = userData;
    }

    @Override
    public UserDto saveUser(UserDto basket) {
        return userData.saveUser(basket);
    }

    @Override
    public UserDto updateUser(UserDto basket) {
        return userData.updateUser(basket);
    }

    @Override
    public UserDto getUserById(Long id) {
        return userData.getUserById(id);
    }

    @Override
    public List<UserDto> getAllUser() {
        return userData.getAllUser();
    }
}
