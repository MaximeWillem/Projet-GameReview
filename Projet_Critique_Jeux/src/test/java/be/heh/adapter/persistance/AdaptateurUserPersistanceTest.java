package be.heh.adapter.persistance;// Importation des classes nécessaires pour les tests
import be.heh.adapter.persistance.Repository.UserRepository;
import be.heh.adapter.persistance.persistance.AdaptateurUserPersistance;
import be.heh.application.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Déclaration de la classe de test pour AdaptateurUserPersistance
public class AdaptateurUserPersistanceTest {

    // Déclaration des variables nécessaires pour les tests
    private UserRepository userRepository;
    private AdaptateurUserPersistance userPersistance;

    // Méthode exécutée avant chaque test pour initialiser les mocks et l'objet à tester
    @BeforeEach
    public void setUp() {
        // Configuration initiale pour chaque test
        userRepository = mock(UserRepository.class);
        userPersistance = new AdaptateurUserPersistance(userRepository);
    }

    // Test de la méthode updateUserDB
    @Test
    public void updateUserDB_ShouldDelegateToRepository() {
        // Arrange
        User inputUser = new User(1, "john.doe", "password123");

        // Act
        // Exécution de la méthode à tester
        userPersistance.updateUserDB(inputUser);

        // Assert
        // Vérification que la méthode updateUserDB du repository a été appelée avec le bon argument
        verify(userRepository, times(1)).updateUserDB(inputUser);
    }

    // Test de la méthode addUserDB
    @Test
    public void addUserDB_ShouldDelegateToRepository() {
        // Arrange
        User inputUser = new User(1, "john.doe", "password123");

        // Act
        // Exécution de la méthode à tester
        userPersistance.addUserDB(inputUser);

        // Assert
        // Vérification que la méthode addUserDB du repository a été appelée avec le bon argument
        verify(userRepository, times(1)).addUserDB(inputUser);
    }

    // Test de la méthode deleteUserDB
    @Test
    public void deleteUserDB_ShouldDelegateToRepository() {
        // Arrange
        int userId = 1;

        // Act
        // Exécution de la méthode à tester
        userPersistance.deleteUserDB(userId);

        // Assert
        // Vérification que la méthode deleteUserDB du repository a été appelée avec le bon argument
        verify(userRepository, times(1)).deleteUserDB(userId);
    }

    // Test de la méthode getUserById
    @Test
    public void getUserById_ShouldDelegateToRepository() {
        // Arrange
        int userId = 1;
        User expectedUser = new User(userId, "john.doe", "password123");
        when(userRepository.getUserById(userId)).thenReturn(expectedUser);

        // Act
        // Exécution de la méthode à tester
        User retrievedUser = userPersistance.getUserById(userId);

        // Assert
        // Vérification que la méthode getUserById du repository a été appelée avec le bon argument
        verify(userRepository, times(1)).getUserById(userId);

        // Vérification des résultats
        assertNotNull(retrievedUser);
        assertEquals(expectedUser, retrievedUser);
    }

    // Test de la méthode getAllUsers
    @Test
    public void getAllUsers_ShouldDelegateToRepository() {
        // Arrange
        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(new User(1, "john.doe", "password123"));
        expectedUsers.add(new User(2, "jane.doe", "secret456"));
        when(userRepository.getAllUsers()).thenReturn(expectedUsers);

        // Act
        // Exécution de la méthode à tester
        List<User> retrievedUsers = userPersistance.getAllUsers();

        // Assert
        // Vérification que la méthode getAllUsers du repository a été appelée
        verify(userRepository, times(1)).getAllUsers();

        // Vérification des résultats
        assertNotNull(retrievedUsers);
        assertEquals(expectedUsers, retrievedUsers);
    }
}
