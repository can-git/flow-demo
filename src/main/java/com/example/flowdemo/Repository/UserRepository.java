package com.example.flowdemo.Repository;

import com.example.flowdemo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);

}
