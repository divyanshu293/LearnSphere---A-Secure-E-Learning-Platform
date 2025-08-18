package com.hashedin.huspark.service;


import com.hashedin.huspark.dao.UserDto;
import com.hashedin.huspark.model.Role;
import com.hashedin.huspark.model.User;
import com.hashedin.huspark.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {


    @Autowired
    UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private ModelMapper modelMapper;


    public UserDto register(User user) {
        if(user.getRole() == null){
            user.setRole(Role.USER);
        }
        user.setPswrd(passwordEncoder.encode(user.getPswrd()));
        userRepository.save(user);
        return modelMapper.map(user , UserDto.class);
    }
}
