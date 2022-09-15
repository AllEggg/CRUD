package web.services;

import org.springframework.stereotype.Service;
import web.entities.User;
import web.repositories.UserRepository;

import java.util.List;
@Service
public class UserServiceBaseImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceBaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.getUser(id);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    @Override
    public User editUser(User user) {
        return userRepository.editUser(user);
    }
}
