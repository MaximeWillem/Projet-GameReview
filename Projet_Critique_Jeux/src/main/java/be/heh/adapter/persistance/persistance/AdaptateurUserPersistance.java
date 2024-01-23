package be.heh.adapter.persistance.persistance;

import be.heh.adapter.persistance.Repository.UserRepository;
import be.heh.application.domain.model.User;
import be.heh.port.out.UserPersistance;
import org.springframework.stereotype.Component;

import java.util.List;

public class AdaptateurUserPersistance implements UserPersistance {

    private UserRepository userRepository;

    public AdaptateurUserPersistance(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void updateUserDB(User user) {
        userRepository.updateUserDB(user);
    }

    @Override
    public void addUserDB(User user) {
        userRepository.addUserDB(user);
    }

    @Override
    public void deleteUserDB(int userId) {
        userRepository.deleteUserDB(userId);
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
