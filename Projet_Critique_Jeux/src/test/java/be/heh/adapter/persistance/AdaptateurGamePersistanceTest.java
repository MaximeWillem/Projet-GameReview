package be.heh.adapter.persistance;// Importation des classes nécessaires pour les tests
import be.heh.adapter.persistance.Repository.GameRepository;
import be.heh.adapter.persistance.persistance.AdaptateurGamePersistance;
import be.heh.application.domain.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Déclaration de la classe de test pour AdaptateurGamePersistance
public class AdaptateurGamePersistanceTest {

    // Déclaration des variables nécessaires pour les tests
    private GameRepository gameRepository;
    private AdaptateurGamePersistance gamePersistance;

    // Méthode exécutée avant chaque test pour initialiser les mocks et l'objet à tester
    @BeforeEach
    public void setUp() {
        // Configuration initiale pour chaque test
        gameRepository = mock(GameRepository.class);
        gamePersistance = new AdaptateurGamePersistance(gameRepository);
    }

    // Test de la méthode updateGameDB
    @Test
    public void updateGameDB_ShouldDelegateToRepository() {
        // Arrange
        Game inputGame = new Game(1, "Chess", "chess.jpg", "Classic board game");

        // Act
        // Exécution de la méthode à tester
        gamePersistance.updateGameDB(inputGame);

        // Assert
        // Vérification que la méthode updateGameDB du repository a été appelée avec le bon argument
        verify(gameRepository, times(1)).updateGameDB(inputGame);
    }

    // Test de la méthode addGameDB
    @Test
    public void addGameDB_ShouldDelegateToRepository() {
        // Arrange
        Game inputGame = new Game(1, "Chess", "chess.jpg", "Classic board game");

        // Act
        // Exécution de la méthode à tester
        gamePersistance.addGameDB(inputGame);

        // Assert
        // Vérification que la méthode addGameDB du repository a été appelée avec le bon argument
        verify(gameRepository, times(1)).addGameDB(inputGame);
    }

    // Test de la méthode deleteGameDB
    @Test
    public void deleteGameDB_ShouldDelegateToRepository() {
        // Arrange
        int gameId = 1;

        // Act
        // Exécution de la méthode à tester
        gamePersistance.deleteGameDB(gameId);

        // Assert
        // Vérification que la méthode deleteGameDB du repository a été appelée avec le bon argument
        verify(gameRepository, times(1)).deleteGameDB(gameId);
    }

    // Test de la méthode getGameById
    @Test
    public void getGameById_ShouldDelegateToRepository() {
        // Arrange
        int gameId = 1;
        Game expectedGame = new Game(gameId, "Chess", "chess.jpg", "Classic board game");
        when(gameRepository.getGameById(gameId)).thenReturn(expectedGame);

        // Act
        // Exécution de la méthode à tester
        Game retrievedGame = gamePersistance.getGameById(gameId);

        // Assert
        // Vérification que la méthode getGameById du repository a été appelée avec le bon argument
        verify(gameRepository, times(1)).getGameById(gameId);

        // Vérification des résultats
        assertNotNull(retrievedGame);
        assertEquals(expectedGame, retrievedGame);
    }

    // Test de la méthode getAllGame
    @Test
    public void getAllGame_ShouldDelegateToRepository() {
        // Arrange
        List<Game> expectedGames = new ArrayList<>();
        expectedGames.add(new Game(1, "Chess", "chess.jpg", "Classic board game"));
        expectedGames.add(new Game(2, "Checkers", "checkers.jpg", "Traditional strategy game"));
        when(gameRepository.getAllGame()).thenReturn(expectedGames);

        // Act
        // Exécution de la méthode à tester
        List<Game> retrievedGames = gamePersistance.getAllGame();

        // Assert
        // Vérification que la méthode getAllGame du repository a été appelée
        verify(gameRepository, times(1)).getAllGame();

        // Vérification des résultats
        assertNotNull(retrievedGames);
        assertEquals(expectedGames, retrievedGames);
    }
}
