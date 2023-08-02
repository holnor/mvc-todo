package hu.holnor.mvctodo.domain;

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
}
