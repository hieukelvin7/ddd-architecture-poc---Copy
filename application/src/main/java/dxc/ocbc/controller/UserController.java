package dxc.ocbc.controller;

import dxc.ocbc.dto.UserDto;
import dxc.ocbc.adapters.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/admin/add")
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @PutMapping("/user/update")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @GetMapping("/admin/get/{id}")
    public UserDto getUserByID(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/admin/get")
    public List<UserDto> getAllUsers() {
        return userService.getAllUser();
    }
}
