package org.example.TP3P2.EXO1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // La méthode findUserById est souvent remplacée par findById de JPA
    User findUserById(long id);
}