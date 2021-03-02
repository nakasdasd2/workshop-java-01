package com.example.KBTG.user;

import com.example.KBTG.ErrorResponse;
import com.example.KBTG.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void success_get_user_id_1() {
        // Act
        UserResponse response
                = restTemplate.getForObject("/user/1", UserResponse.class);
        // Assert
        assertEquals(1, response.getId());
        assertEquals("somkiat", response.getName());
        assertEquals(30, response.getAge());
        // Quiz
        UserResponse expected = new UserResponse(1, "somkiat", 30);
        assertEquals(expected, response);
    }

    @Test
    public void not_found_id15() {
        try {
            // Act
            ErrorResponse response
                    = restTemplate.getForObject("/user/15", ErrorResponse.class);
            fail();
        }catch (Exception e) {
            assertEquals("User not found id=15", e.getMessage());
        }
    }

}