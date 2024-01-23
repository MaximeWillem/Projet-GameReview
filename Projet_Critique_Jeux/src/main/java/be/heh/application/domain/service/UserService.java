package be.heh.application.domain.service;

import be.heh.application.domain.model.User;
import be.heh.port.in.UserUseCase;
import be.heh.port.out.UserPersistance;
import org.springframework.stereotype.Service;

import java.util.List;

public class UserService implements UserUseCase {
    private final UserPersistance userPersistance;

    public UserService(UserPersistance userPersistance) {
        this.userPersistance = userPersistance;
    }

    @Override
    public User createUser(User user) {
        userPersistance.addUserDB(user);
        return user;
    }

    @Override
    public boolean deleteUser(int userId) {
        userPersistance.deleteUserDB(userId);
        return true;
    }

    @Override
    public User getUserById(int userId) {
        return userPersistance.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userPersistance.getAllUsers();
    }
    @Override
    public User updateUser(User user) {
        userPersistance.updateUserDB(user);
        return user;
    }
}
