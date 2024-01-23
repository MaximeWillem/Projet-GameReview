package be.heh.adapter.web;

import be.heh.application.domain.model.Game;
import be.heh.port.in.GameUseCase;
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

class AdaptateurGameControlleurTest {

    // Mock pour le cas d'utilisation GameUseCase
    @Mock
    private GameUseCase gameUseCase;

    // Injecte les mocks dans le contrôleur
    @InjectMocks
    private AdaptateurGameControlleur gameController;

    // Méthode appelée avant chaque test pour initialiser les mocks
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Teste le scénario où getGameById doit retourner un jeu
    @Test
    void getGameById_ShouldReturnGame() {
        // Arrange
        int gameId = 1;
        Game mockGame = new Game(gameId, "Test Game", "image_url", "Description");
        when(gameUseCase.getGameById(gameId)).thenReturn(mockGame);

        // Act
        ResponseEntity<Game> response = gameController.getGameById(gameId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockGame, response.getBody());
    }

    // Teste le scénario où getGameById doit retourner NotFound
    @Test
    void getGameById_ShouldReturnNotFound() {
        // Arrange
        int gameId = 1;
        when(gameUseCase.getGameById(gameId)).thenReturn(null);

        // Act
        ResponseEntity<Game> response = gameController.getGameById(gameId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Teste le scénario où getAllGame doit retourner une liste de jeux
    @Test
    void getAllGame_ShouldReturnGames() {
        // Arrange
        List<Game> mockGames = new ArrayList<>();
        mockGames.add(new Game(1, "Game1", "image1", "Description1"));
        mockGames.add(new Game(2, "Game2", "image2", "Description2"));
        when(gameUseCase.getAllGame()).thenReturn(mockGames);

        // Act
        ResponseEntity<List<Game>> response = gameController.getAllGame();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockGames, response.getBody());
    }

    // Teste le scénario où getAllGame doit retourner NotFound
    @Test
    void getAllGame_ShouldReturnNotFound() {
        // Arrange
        when(gameUseCase.getAllGame()).thenReturn(new ArrayList<>());

        // Act
        ResponseEntity<List<Game>> response = gameController.getAllGame();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Teste le scénario où deleteGame doit retourner NoContent
    @Test
    void deleteGame_ShouldReturnNoContent() {
        // Arrange
        int gameId = 1;
        when(gameUseCase.deleteGame(gameId)).thenReturn(true);

        // Act
        ResponseEntity<Void> response = gameController.deleteGame(gameId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    // Teste le scénario où deleteGame doit retourner NotFound
    @Test
    void deleteGame_ShouldReturnNotFound() {
        // Arrange
        int gameId = 1;
        when(gameUseCase.deleteGame(gameId)).thenReturn(false);

        // Act
        ResponseEntity<Void> response = gameController.deleteGame(gameId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Teste le scénario où createGame doit retourner CreatedGame
    @Test
    void createGame_ShouldReturnCreatedGame() {
        // Arrange
        Game mockGame = new Game(1, "Test Game", "image_url", "Description");
        when(gameUseCase.createGame(mockGame)).thenReturn(mockGame);

        // Act
        ResponseEntity<Game> response = gameController.createGame(mockGame);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockGame, response.getBody());
    }

    // Teste le scénario où createGame doit retourner InternalServerError
    @Test
    void createGame_ShouldReturnInternalServerError() {
        // Arrange
        Game mockGame = new Game(1, "Test Game", "image_url", "Description");
        when(gameUseCase.createGame(mockGame)).thenReturn(null);

        // Act
        ResponseEntity<Game> response = gameController.createGame(mockGame);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    // Teste le scénario où updateGame doit retourner UpdatedGame
    @Test
    void updateGame_ShouldReturnUpdatedGame() {
        // Arrange
        int gameId = 1;
        Game mockUpdatedGame = new Game(gameId, "Updated Game", "updated_image", "Updated Description");
        when(gameUseCase.updateGame(any(Game.class))).thenReturn(mockUpdatedGame);

        // Act
        ResponseEntity<Game> response = gameController.updateGame(gameId, mockUpdatedGame);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUpdatedGame, response.getBody());
    }

    // Teste le scénario où updateGame doit retourner NotFound
    @Test
    void updateGame_ShouldReturnNotFound() {
        // Arrange
        int gameId = 1;
        Game mockUpdatedGame = new Game(gameId, "Updated Game", "updated_image", "Updated Description");
        when(gameUseCase.updateGame(new Game(gameId, "Updated Game", "updated_image", "Updated Description"))).thenReturn(null);

        // Act
        ResponseEntity<Game> response = gameController.updateGame(gameId, mockUpdatedGame);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
