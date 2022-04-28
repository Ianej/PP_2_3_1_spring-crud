package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Transactional
    @Override
    public void addUser(String name, String lastName, int age) {
        userDao.addUser(name, lastName, age);
    }
    @Transactional
    @Override
    public void updateUser(long id, String name, String lastName, int age) {
        userDao.updateUser(id,  name, lastName, age);
    }
    @Transactional
    @Override
    public void removeUser(long id) {
        userDao.removeUser(id);
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }
}
