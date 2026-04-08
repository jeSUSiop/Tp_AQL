package org.example.TP3P1.EXO1;

public class UserService {
    private final UserRepository userRepository;

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