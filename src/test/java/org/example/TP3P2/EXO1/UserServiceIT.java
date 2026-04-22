package org.example.TP3P2.EXO1;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers // Gère le cycle de vie du conteneur (démarrage/arrêt) [cite: 39, 44]
public class UserServiceIT {

    // Définition du conteneur MySQL [cite: 84, 87]
    @Container
    private static final MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0.30")
            .withDatabaseName("testdb") // [cite: 90]
            .withUsername("root")       // [cite: 88]
            .withPassword("password");  // [cite: 89]

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // Cette méthode permet d'injecter dynamiquement l'URL du conteneur (port aléatoire) dans Spring [cite: 95]
    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }

    @Test
    void testGetUserById_Success() {
        System.out.println("hii");
        // 1. Préparation : On insère un utilisateur réel en base via le repository [cite: 102, 103]
        User user = new User(1L, "Alice", "alice@example.com");
        userRepository.save(user); // [cite: 105, 137]

        // 2. Action : On récupère cet utilisateur via le service
        User result = userService.getUserById(1L);

        // 3. Vérification : Les données doivent être identiques [cite: 106, 112, 121]
        assertNotNull(result);
        assertEquals("Alice", result.getName());
        assertEquals("alice@example.com", result.getEmail());
    }

    @Test
    void testGetUserById_NotFound() {
        // Vérifier qu'une exception est bien levée si l'utilisateur n'existe pas
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getUserById(999L);
        });
    }
}
