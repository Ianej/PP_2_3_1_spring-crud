package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    void addUser(String name, String lastName, int age);
    void updateUser(long id, String name, String lastName, int age);
    void removeUser(long id);

    User getUser(long id);
}
