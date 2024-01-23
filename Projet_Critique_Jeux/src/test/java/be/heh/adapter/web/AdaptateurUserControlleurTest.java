// Importation des classes nécessaires pour les tests
package be.heh.adapter.web;

import be.heh.application.domain.model.User;
import be.heh.port.in.UserUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Déclaration de la classe de test pour la classe AdaptateurUserController
class AdaptateurUserControllerTest {

    // Annotation @Mock pour créer un mock du UserUseCase
    @Mock
    private UserUseCase userUseCase;

    // Annotation @InjectMocks pour injecter le mock dans AdaptateurUserController
    @InjectMocks
    private AdaptateurUserController userController;

    // Méthode exécutée avant chaque test pour initialiser les mocks
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test de la méthode getUserById
    @Test
    void getUserById_ShouldReturnUser() {
        // Arrange
        int userId = 1;
        User mockUser = new User(userId, "testUser", "password");
        when(userUseCase.getUserById(userId)).thenReturn(mockUser);

        // Act
        ResponseEntity<User> response = userController.getUserById(userId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUser, response.getBody());
    }

    // Test de la méthode getUserById en cas de non-existence de l'utilisateur
    @Test
    void getUserById_ShouldReturnNotFound() {
        // Arrange
        int userId = 1;
        when(userUseCase.getUserById(userId)).thenReturn(null);

        // Act
        ResponseEntity<User> response = userController.getUserById(userId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de la méthode getAllUsers
    @Test
    void getAllUsers_ShouldReturnUsers() {
        // Arrange
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(new User(1, "user1", "password1"));
        mockUsers.add(new User(2, "user2", "password2"));
        when(userUseCase.getAllUsers()).thenReturn(mockUsers);

        // Act
        ResponseEntity<List<User>> response = userController.getAllUsers();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUsers, response.getBody());
    }

    // Test de la méthode getAllUsers en cas de non-existence d'utilisateurs
    @Test
    void getAllUsers_ShouldReturnNotFound() {
        // Arrange
        when(userUseCase.getAllUsers()).thenReturn(new ArrayList<>());

        // Act
        ResponseEntity<List<User>> response = userController.getAllUsers();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de la méthode deleteUser
    @Test
    void deleteUser_ShouldReturnNoContent() {
        // Arrange
        int userId = 1;
        when(userUseCase.deleteUser(userId)).thenReturn(true);

        // Act
        ResponseEntity<Void> response = userController.deleteUser(userId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    // Test de la méthode deleteUser en cas de non-existence de l'utilisateur à supprimer
    @Test
    void deleteUser_ShouldReturnNotFound() {
        // Arrange
        int userId = 1;
        when(userUseCase.deleteUser(userId)).thenReturn(false);

        // Act
        ResponseEntity<Void> response = userController.deleteUser(userId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de la méthode createUser
    @Test
    void createUser_ShouldReturnCreatedUser() {
        // Arrange
        User mockUser = new User(1, "testUser", "password");
        when(userUseCase.createUser(mockUser)).thenReturn(mockUser);

        // Act
        ResponseEntity<User> response = userController.createUser(mockUser);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockUser, response.getBody());
    }

    // Test de la méthode createUser en cas d'échec de création de l'utilisateur
    @Test
    void createUser_ShouldReturnInternalServerError() {
        // Arrange
        User mockUser = new User(1, "testUser", "password");
        when(userUseCase.createUser(mockUser)).thenReturn(null);

        // Act
        ResponseEntity<User> response = userController.createUser(mockUser);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    // Test de la méthode updateUser
    @Test
    void updateUser_ShouldReturnUpdatedUser() {
        // Arrange
        int userId = 1;
        User mockUpdatedUser = new User(userId, "updatedUser", "updatedPassword");
        when(userUseCase.updateUser(any(User.class))).thenReturn(mockUpdatedUser);

        // Act
        ResponseEntity<User> response = userController.updateUser(userId, mockUpdatedUser);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUpdatedUser, response.getBody());
    }

    // Test de la méthode updateUser en cas de non-existence de l'utilisateur à mettre à jour
    @Test
    void updateUser_ShouldReturnNotFound() {
        // Arrange
        int userId = 1;
        User mockUpdatedUser = new User(userId, "updatedUser", "updatedPassword");
        when(userUseCase.updateUser(new User(userId, "updatedUser", "updatedPassword"))).thenReturn(null);

        // Act
        ResponseEntity<User> response = userController.updateUser(userId, mockUpdatedUser);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
