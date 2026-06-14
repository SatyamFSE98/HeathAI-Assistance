package com.healthbot.user_service.service;

import com.healthbot.user_service.dto.LoginRequest;
import com.healthbot.user_service.dto.RegisterRequest;
import com.healthbot.user_service.dto.UserResponse;
import com.healthbot.user_service.entity.User;
import com.healthbot.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse register(RegisterRequest request){

        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already registered");
        }

        User user  = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getEmail());

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);

    }

    public UserResponse login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                 ()-> new RuntimeException("Invalid email or password")
        );

        if(!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Password is invalid");
        }
        return mapToResponse(user);
    }

    public UserResponse getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(()->
                new RuntimeException("user not found"));

        return mapToResponse(user);
    }



    private UserResponse mapToResponse(User user) {
        return  new UserResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getRole()
        );
    }

}
