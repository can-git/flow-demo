package com.example.flowdemo.services;


import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthService {

//    @Autowired
//    private UserRepository userRepository;

    final private Map<String, User> users = Map.of(
            "can", new User("can", "123", new ArrayList<>()),
            "tugce", new User("tugce", "456", new ArrayList<>())
    );

    public User getUserByUsername(String username){
        return users.get(username);
//        return userRepository.findByUserName(username);
    }

//    public List<User> createAll(){
//
////        CreateUserRequest user1 = new CreateUserRequest();
////        user1.setId("1");
////        user1.setUsername("can");
////        user1.setPassword("123");
////
////        CreateUserRequest user2 = new CreateUserRequest();
////        user2.setId("2");
////        user2.setUsername("tugce");
////        user2.setPassword("456");
////
////        final List<CreateUserResponse> userResponseList = new ArrayList<>();
////        CreateUserResponse userResponse1 = new CreateUserResponse();
////        userResponse1.accept(user1.get());
////        CreateUserResponse userResponse2 = new CreateUserResponse();
////        userResponse2.accept(user2.get());
////        userResponseList.add(userResponse1);
////        userResponseList.add(userResponse2);
//
//
//        return userRepository.saveAll(userResponseList);
//    }
}
