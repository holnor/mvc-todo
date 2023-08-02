package hu.holnor.mvctodo.service;

import hu.holnor.mvctodo.domain.Task;
import hu.holnor.mvctodo.domain.User;
import hu.holnor.mvctodo.dto.incomming.CreateNewTaskCommand;
import hu.holnor.mvctodo.repository.TaskRepository;
import hu.holnor.mvctodo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaskService {

    private TaskRepository taskRepository;
    private UserRepository userRepository;


    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }


    public void createNewTask(CreateNewTaskCommand createNewTaskCommand) {
        User userToAssignTaskFor = userRepository.findById(createNewTaskCommand.getUserId()).orElseThrow(EntityNotFoundException::new);
        Task task = new Task(createNewTaskCommand);
        task.setUser(userToAssignTaskFor);
        this.taskRepository.save(task);

    }
}
