// Importation des classes nécessaires pour les tests
package be.heh.application.domain.service;

import be.heh.application.domain.model.User;
import be.heh.port.out.UserPersistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Déclaration de la classe de test pour la classe UserService
public class UserServiceTest {

    // Déclaration des variables nécessaires pour les tests
    private UserService userService;
    private UserPersistance userPersistance;

    // Méthode exécutée avant chaque test pour initialiser les mocks et le service
    @BeforeEach
    public void setUp() {
        // Configuration initiale pour chaque test
        userPersistance = mock(UserPersistance.class);
        userService = new UserService(userPersistance);
    }

    // Test de la méthode createUser
    @Test
    public void createUser_ShouldReturnCreatedUser() {
        // Arrange
        // Mise en place des données d'entrée
        User inputUser = new User(1, "john.doe", "password123");

        // Act
        // Exécution de la méthode à tester
        doNothing().when(userPersistance).addUserDB(inputUser);
        User createdUser = userService.createUser(inputUser);

        // Assert
        // Vérification des résultats
        assertNotNull(createdUser);
        assertEquals(inputUser, createdUser);

        // Vérifie que la méthode addUserDB a été appelée avec le bon argument
        verify(userPersistance, times(1)).addUserDB(inputUser);
    }

    // Test de la méthode deleteUser
    @Test
    public void deleteUser_ShouldReturnTrue() {
        // Arrange
        // Mise en place des données d'entrée
        int userId = 1;

        // Act
        // Exécution de la méthode à tester
        doNothing().when(userPersistance).deleteUserDB(userId);
        boolean result = userService.deleteUser(userId);

        // Assert
        // Vérification des résultats
        assertTrue(result);

        // Vérifie que la méthode deleteUserDB a été appelée avec le bon argument
        verify(userPersistance, times(1)).deleteUserDB(userId);
    }

    // Test de la méthode getUserById
    @Test
    public void getUserById_ShouldReturnUser() {
        // Arrange
        // Mise en place des données d'entrée
        int userId = 1;
        User expectedUser = new User(userId, "john.doe", "password123");

        // Act
        // Exécution de la méthode à tester
        when(userPersistance.getUserById(userId)).thenReturn(expectedUser);
        User retrievedUser = userService.getUserById(userId);

        // Assert
        // Vérification des résultats
        assertNotNull(retrievedUser);
        assertEquals(expectedUser, retrievedUser);
    }

    // Test de la méthode getAllUsers
    @Test
    public void getAllUsers_ShouldReturnListOfUsers() {
        // Arrange
        // Mise en place des données d'entrée
        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(new User(1, "john.doe", "password123"));
        expectedUsers.add(new User(2, "jane.doe", "secret456"));

        // Act
        // Exécution de la méthode à tester
        when(userPersistance.getAllUsers()).thenReturn(expectedUsers);
        List<User> retrievedUsers = userService.getAllUsers();

        // Assert
        // Vérification des résultats
        assertNotNull(retrievedUsers);
        assertEquals(expectedUsers, retrievedUsers);
    }

    // Test de la méthode updateUser
    @Test
    public void updateUser_ShouldReturnUpdatedUser() {
        // Arrange
        // Mise en place des données d'entrée
        User inputUser = new User(1, "john.doe", "password123");

        // Act
        // Exécution de la méthode à tester
        doNothing().when(userPersistance).updateUserDB(inputUser);
        User updatedUser = userService.updateUser(inputUser);

        // Assert
        // Vérification des résultats
        assertNotNull(updatedUser);
        assertEquals(inputUser, updatedUser);

        // Vérifie que la méthode updateUserDB a été appelée avec le bon argument
        verify(userPersistance, times(1)).updateUserDB(inputUser);
    }
}
