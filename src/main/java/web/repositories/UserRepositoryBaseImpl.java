package web.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryBaseImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
        return user;
    }

    @Override
    @Transactional
    public User editUser(User user) {
        entityManager.merge(user);
        entityManager.flush();

        return user;
    }


    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = getUser(id);
        if (user == null) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        entityManager.flush();
    }
}
