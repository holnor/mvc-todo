package hu.holnor.mvctodo.domain;

import hu.holnor.mvctodo.dto.incomming.CreateNewTaskCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private Long id;
    private String name;
    private String description;
    private Integer complexity;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task(CreateNewTaskCommand createNewTaskCommand) {
        this.name = createNewTaskCommand.getName();
        this.description = createNewTaskCommand.getDescription();
        this.complexity = createNewTaskCommand.getComplexity();
    }
}
