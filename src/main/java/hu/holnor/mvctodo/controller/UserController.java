package hu.holnor.mvctodo.controller;

import hu.holnor.mvctodo.dto.incomming.RegisterUserCommand;
import hu.holnor.mvctodo.dto.outgoing.FindUserByIdDetails;
import hu.holnor.mvctodo.dto.outgoing.UserListItem;
import hu.holnor.mvctodo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void>registerUser(@RequestBody RegisterUserCommand registerUserCommand){
        this.userService.registerUser(registerUserCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserListItem>>findAllUsers(){
        return new ResponseEntity<>(this.userService.findAllUsers(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<FindUserByIdDetails>findUserById(@PathVariable Long id){
        return new ResponseEntity<>(
                this.userService.findUserById(id), HttpStatus.OK
        );
    }

    //TODO: list all user


    //TODO: update user by ID
    //TODO: delete user by ID

}
