package web.services;

import web.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Long id);

    void deleteUser(Long id);

    User createUser(User user);

    User editUser(User user);
}
