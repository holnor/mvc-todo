package hu.holnor.mvctodo.service;

import hu.holnor.mvctodo.domain.User;
import hu.holnor.mvctodo.dto.incomming.RegisterUserCommand;
import hu.holnor.mvctodo.dto.outgoing.FindUserByIdData;
import hu.holnor.mvctodo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
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
