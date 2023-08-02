package hu.holnor.mvctodo.controller;

import hu.holnor.mvctodo.dto.incomming.CreateNewTaskCommand;
import hu.holnor.mvctodo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //TODO: task can be created
    @PostMapping
    public ResponseEntity<Void>createNewTask(@RequestBody CreateNewTaskCommand createNewTaskCommand) {
        taskService.createNewTask(createNewTaskCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    //TODO: task can be updated by ID
    //TODO: task can be Deleted by ID
    //TODO: tasks can be listed
}
