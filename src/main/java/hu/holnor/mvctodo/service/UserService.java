package hu.holnor.mvctodo.service;

import hu.holnor.mvctodo.domain.User;
import hu.holnor.mvctodo.dto.incomming.RegisterUserCommand;
import hu.holnor.mvctodo.dto.outgoing.FindUserByIdDetails;
import hu.holnor.mvctodo.dto.outgoing.UserListItem;
import hu.holnor.mvctodo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public FindUserByIdDetails findUserById(Long id) {
        return new FindUserByIdDetails(
                this.userRepository.findById(id).orElseThrow(EntityNotFoundException::new)
        );
    }

    public List<UserListItem> findAllUsers() {
        return userRepository.findAll().stream()
                .map(UserListItem::new).collect(Collectors.toList());
    }
}
