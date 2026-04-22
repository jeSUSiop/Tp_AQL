package org.example.TP3P2.EXO1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity // Indique que cette classe est une entité JPA [cite: 52]
@Table(name = "users") // Nom de la table dans MySQL
public class User {

    @Id // Définit la clé primaire [cite: 107, 118]
    private long id;
    private String name;
    private String email;

    // JPA nécessite un constructeur vide (sans arguments)
    public User() {}

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Garde tes getters, equals et hashCode existants...
    public long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}