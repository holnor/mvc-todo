package hu.holnor.mvctodo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //TODO: create user
    @PostMapping
    public ResponseEntity<Void>registerUser(@RequestBody RegisterUserCommand registerUserCommand){
        this.userService.registerUser(registerUserCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }







    //TODO: list all user
    //TODO: find user by ID
    //TODO: update user by ID
    //TODO: delete user by ID

}
