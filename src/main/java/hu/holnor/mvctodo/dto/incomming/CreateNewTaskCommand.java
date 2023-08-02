package hu.holnor.mvctodo.dto.incomming;

import hu.holnor.mvctodo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateNewTaskCommand {
    private String name;
    private String description;
    private Integer complexity;
    private Long userId;
}
