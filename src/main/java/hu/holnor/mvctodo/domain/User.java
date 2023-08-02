package hu.holnor.mvctodo.domain;

import hu.holnor.mvctodo.dto.incomming.RegisterUserCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    public User(RegisterUserCommand registerUserCommand) {
        this.firstName = registerUserCommand.getFirstName();
        this.lastName = registerUserCommand.getLastName();
        this.email = registerUserCommand.getEmail();
        this.role = "USER";
    }
}
