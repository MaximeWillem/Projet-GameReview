package be.heh.port.out;

import be.heh.application.domain.model.User;

import java.util.List;

public interface UserPersistance {
    void addUserDB(User user);
    void deleteUserDB(int userId);
    void updateUserDB(User user);
    User getUserById(int userId);
    List<User> getAllUsers();
}
