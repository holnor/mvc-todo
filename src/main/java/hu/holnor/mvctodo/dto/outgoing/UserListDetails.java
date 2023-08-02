package hu.holnor.mvctodo.dto.outgoing;

import hu.holnor.mvctodo.domain.Task;
import hu.holnor.mvctodo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserListDetails {
    private String firstName;
    private String lastName;
    private String email;
    private Integer numberOfTasks;
    private Integer totalComplexity;

    public UserListDetails(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.numberOfTasks = user.getTasks().size();
        this.totalComplexity = user.getTasks().stream()
                .mapToInt(Task::getComplexity).sum();
    }
}
