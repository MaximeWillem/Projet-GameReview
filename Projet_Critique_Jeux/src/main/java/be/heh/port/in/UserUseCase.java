package be.heh.port.in;

import be.heh.application.domain.model.User;

import java.util.List;

public interface UserUseCase {
    User createUser(User user);
    boolean deleteUser(int userId);
    User getUserById(int userId);
    User updateUser(User user);
    List<User> getAllUsers();

}
