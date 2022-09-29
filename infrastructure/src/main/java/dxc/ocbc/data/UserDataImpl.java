package dxc.ocbc.data;

import dxc.ocbc.dto.UserDto;
import dxc.ocbc.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import dxc.ocbc.mappers.UserMapper;
import dxc.ocbc.repository.UserRepository;
import dxc.ocbc.adapters.data.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class UserDataImpl implements UserData,UserDetailsService{
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else {
            log.info("User is founded in the database: {}",username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        String a = user.getRole();
        authorities.add(new SimpleGrantedAuthority(a));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
    @Override
    public UserDto saveUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        User userSave = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDto(userSave);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return saveUser(userDto);
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return UserMapper.INSTANCE.userToUserDto(user.get());
        }
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> userList = userRepository.findAll();

        return UserMapper.INSTANCE.userListToUserDtoList(userList);
    }
}
