package hu.holnor.mvctodo.dto.incomming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterUserCommand {
    private String firstName;
    private String lastName;
    private String email;
}
