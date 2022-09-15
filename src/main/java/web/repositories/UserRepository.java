package web.repositories;

import web.entities.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User getUser(Long id);

    User createUser(User user);

    User editUser(User user);


    void deleteUser(Long id);
}
