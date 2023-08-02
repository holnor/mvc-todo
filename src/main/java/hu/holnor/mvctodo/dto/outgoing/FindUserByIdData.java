package hu.holnor.mvctodo.dto.outgoing;

import hu.holnor.mvctodo.domain.Task;
import hu.holnor.mvctodo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class FindUserByIdData {
    private String firstName;
    private String lastName;
    private String email;
    private List<String> tasks;

    public FindUserByIdData(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.tasks = user.getTasks().stream()
                .map(Task::getName).collect(Collectors.toList());
    }
}
