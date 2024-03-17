package br.ufpe.cin.futebolamigouser.models;

import br.ufpe.cin.futebolamigouser.services.impl.Prototype;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@ToString
@Table(name = "users")
public class User implements Prototype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    private User(User user) {
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.userName = user.userName;
        this.password = user.password;
    }
    public User() {
    }

    @Override
    public Prototype clone() {
        return new User(this);
    }
}
