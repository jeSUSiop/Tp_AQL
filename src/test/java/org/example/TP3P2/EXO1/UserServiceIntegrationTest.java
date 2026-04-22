package org.example.TP3P2.EXO1;

import org.example.TP3P2.EXO1.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // Loads the full Spring context for integration testing [cite: 4, 38]
@Testcontainers // Automatically manages container lifecycle [cite: 38, 44]
public class UserServiceIntegrationTest {


    @Container // Starts a real MySQL container before tests [cite: 84, 86]
    private static final MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0.30")
            .withDatabaseName("testdb")
            .withUsername("root")
            .withPassword("password");

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // Dynamically maps the container's random port to Spring properties [cite: 91, 95]
    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }

    @Test
    void getUserById_shouldReturnUser_fromRealDatabase() {
        // Arrange: Save a real user to the containerized DB
        User user = new User(1L, "abderrahmene belhadj", "abderrahmene@gmail.com");
        userRepository.save(user); // Assuming repository has a save method

        // Act: Retrieve via service
        User actualUser = userService.getUserById(1L);

        // Assert: Verify real data integrity [cite: 106, 112]
        assertNotNull(actualUser);
        assertEquals("abderrahmene belhadj", actualUser.getName());
    }

    @Test
    void getUserById_shouldThrowException_whenUserNotFoundInDB() {
        // Act & Assert
        long userId = 999L;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userService.getUserById(userId));

        assertEquals("User not found with id: " + userId, exception.getMessage());
    }
}