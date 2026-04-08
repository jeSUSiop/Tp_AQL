package org.example.TP3P1.EXO1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    void getUserById_shouldReturnUser_whenUserExists() {
        System.out.println("hiiiiii");
        // Arrange
        long userId = 5;
        User user = new User(userId, "abderrahmene belhadj", "abderrahmene@gmail.com");

        // Définir le comportement du mock
        when(userRepository.findUserById(userId)).thenReturn(user);

        // Act
        User actualUser = userService.getUserById(userId);

        // Assert
        assertEquals(user, actualUser);

        // Vérification que la méthode du mock a été appelée avec le bon argument
        verify(userRepository).findUserById(userId);
    }

    @Test
    void getUserById_shouldThrowException_whenUserDoesNotExist() {
        // Arrange
        long userId = 5;

        // Définir le comportement du mock pour retourner null
        when(userRepository.findUserById(userId)).thenReturn(null);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userService.getUserById(userId));

        assertEquals("User not found with id: " + userId, exception.getMessage());

        // Vérification que la méthode du mock a été appelée avec le bon argument
        verify(userRepository).findUserById(userId);
    }
}