package org.example.TP3P2.EXO1;

import org.springframework.stereotype.Service;

@Service // Cette annotation est CRUCIALE pour l'injection de dépendances
public class UserService {
    private final UserRepository userRepository;

    // Spring utilisera ce constructeur pour injecter le UserRepository automatiquement
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(long id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
        return user;
    }
}