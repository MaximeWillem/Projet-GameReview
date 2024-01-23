// Importation des classes nécessaires pour les tests
package be.heh.application.domain.service;

import be.heh.application.domain.model.Game;
import be.heh.port.out.GamePersistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Déclaration de la classe de test pour la classe GameService
public class GameServiceTest {

    // Déclaration des variables nécessaires pour les tests
    private GameService gameService;
    private GamePersistance gamePersistance;

    // Méthode exécutée avant chaque test pour initialiser les mocks et le service
    @BeforeEach
    public void setUp() {
        // Configuration initiale pour chaque test
        gamePersistance = mock(GamePersistance.class);
        gameService = new GameService(gamePersistance);
    }

    // Test de la méthode createGame
    @Test
    public void createGame_ShouldReturnCreatedGame() {
        // Arrange
        // Mise en place des données d'entrée
        Game inputGame = new Game(1, "Chess", "chess.jpg", "Classic board game");

        // Act
        // Exécution de la méthode à tester
        doNothing().when(gamePersistance).addGameDB(inputGame);
        Game createdGame = gameService.createGame(inputGame);

        // Assert
        // Vérification des résultats
        assertNotNull(createdGame);
        assertEquals(inputGame, createdGame);

        // Vérifie que la méthode addGameDB a été appelée avec le bon argument
        verify(gamePersistance, times(1)).addGameDB(inputGame);
    }

    // Test de la méthode deleteGame
    @Test
    public void deleteGame_ShouldReturnTrue() {
        // Arrange
        // Mise en place des données d'entrée
        int gameId = 1;

        // Act
        // Exécution de la méthode à tester
        doNothing().when(gamePersistance).deleteGameDB(gameId);
        boolean result = gameService.deleteGame(gameId);

        // Assert
        // Vérification des résultats
        assertTrue(result);

        // Vérifie que la méthode deleteGameDB a été appelée avec le bon argument
        verify(gamePersistance, times(1)).deleteGameDB(gameId);
    }

    // Test de la méthode getGameById
    @Test
    public void getGameById_ShouldReturnGame() {
        // Arrange
        // Mise en place des données d'entrée
        int gameId = 1;
        Game expectedGame = new Game(gameId, "Chess", "chess.jpg", "Classic board game");

        // Act
        // Exécution de la méthode à tester
        when(gamePersistance.getGameById(gameId)).thenReturn(expectedGame);
        Game retrievedGame = gameService.getGameById(gameId);

        // Assert
        // Vérification des résultats
        assertNotNull(retrievedGame);
        assertEquals(expectedGame, retrievedGame);
    }

    // Test de la méthode getAllGame
    @Test
    public void getAllGame_ShouldReturnListOfGames() {
        // Arrange
        // Mise en place des données d'entrée
        List<Game> expectedGames = new ArrayList<>();
        expectedGames.add(new Game(1, "Chess", "chess.jpg", "Classic board game"));
        expectedGames.add(new Game(2, "Checkers", "checkers.jpg", "Traditional strategy game"));

        // Act
        // Exécution de la méthode à tester
        when(gamePersistance.getAllGame()).thenReturn(expectedGames);
        List<Game> retrievedGames = gameService.getAllGame();

        // Assert
        // Vérification des résultats
        assertNotNull(retrievedGames);
        assertEquals(expectedGames, retrievedGames);
    }

    // Test de la méthode updateGame
    @Test
    public void updateGame_ShouldReturnUpdatedGame() {
        // Arrange
        // Mise en place des données d'entrée
        Game inputGame = new Game(1, "Chess", "chess.jpg", "Classic board game");

        // Act
        // Exécution de la méthode à tester
        doNothing().when(gamePersistance).updateGameDB(inputGame);
        Game updatedGame = gameService.updateGame(inputGame);

        // Assert
        // Vérification des résultats
        assertNotNull(updatedGame);
        assertEquals(inputGame, updatedGame);

        // Vérifie que la méthode updateGameDB a été appelée avec le bon argument
        verify(gamePersistance, times(1)).updateGameDB(inputGame);
    }
}
