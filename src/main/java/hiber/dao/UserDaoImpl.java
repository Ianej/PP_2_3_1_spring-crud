package hiber.dao;

import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext//(unitName = "entityManager")
    //@Autowired
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void addUser(String name, String lastName, int age) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        entityManager.persist(user);
    }

    @Override
    public void updateUser(long id, String name, String lastName, int age) {
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        entityManager.merge(user);
        System.out.println("updateUser");
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }
}
