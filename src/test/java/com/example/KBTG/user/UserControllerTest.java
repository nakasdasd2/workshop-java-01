package com.example.KBTG.user;
import com.example.KBTG.UserResponse;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void success_get_user_id_1() {
        // Act
        UserResponse2 response
                = restTemplate.getForObject("/user/1", UserResponse2.class);
        // Assert
        assertEquals(1, response.getId());
        assertEquals("somkiat", response.getName());
        assertEquals(30, response.getAge());
        // Quiz
        UserResponse2 expected = new UserResponse2(1, "somkiat", 30){
            @Override
            public String toString() {
                return String.format(response.getId() + ":" + response.getName()+":"+response.getAge());
            }
        };
        assertEquals(expected, response);
    }

}

class UserResponse2 extends com.example.KBTG.UserResponse {

    public UserResponse2(int i, String somkiat, int i1) {
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o.toString() == this.toString()) {
            return true;
        }else{
            return false;
        }
    }
        @Override
    public String toString() {
        return String.format(this.getId() + ":" + this.getName()+":"+this.getAge());
    }
}