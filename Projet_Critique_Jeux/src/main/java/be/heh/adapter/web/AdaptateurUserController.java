package be.heh.adapter.web;

import be.heh.application.domain.model.User;
import be.heh.application.domain.service.UserService;
import be.heh.port.in.UserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AdaptateurUserController {

    private final UserUseCase userUseCase;

    public AdaptateurUserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        User user = userUseCase.getUserById(userId);

        if (user != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userUseCase.getAllUsers();

        if (!users.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(users);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }



    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        boolean deleted = userUseCase.deleteUser(userId);

        if (deleted) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }


    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User userData) {
        User createdUser = userUseCase.createUser(userData);

        if (createdUser != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdUser);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
    @PutMapping("/user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User updatedUserData) {
        User updatedUser = userUseCase.updateUser(new User(userId, updatedUserData.getUsername(), updatedUserData.getPassword()));

        if (updatedUser != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(updatedUser);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
