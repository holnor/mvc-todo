package hu.holnor.mvctodo.controller;

import hu.holnor.mvctodo.domain.User;
import hu.holnor.mvctodo.dto.outgoing.FindUserByIdData;
import hu.holnor.mvctodo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void registerUser(RegisterUserCommand registerUserCommand) {
        this.userRepository.save(new User(registerUserCommand));
    }

    public FindUserByIdData findUserById(Long id) {
        return new FindUserByIdData(
                this.userRepository.findById(id).orElseThrow(EntityNotFoundException::new)
        );
    }
}
