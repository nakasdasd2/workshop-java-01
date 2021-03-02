package com.example.KBTG;

import com.example.KBTG.user.MyUser;
import com.example.KBTG.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public UserResponse getInfo(int id) {

        try{
            Optional<MyUser> user = userRepository.findById(1);

            return new UserResponse(user.get().getId(), user.get().getName(), user.get().getAge());
        }catch(Exception e){
            throw new RuntimeException("User not found id="+ id);
        }
        /*
        if(id <= 10) {
            // Success
            return new UserResponse(id, "somkiat", 30);
        }
        */

        // Fail
       // throw new RuntimeException("User not found id="+ id);
    }
}