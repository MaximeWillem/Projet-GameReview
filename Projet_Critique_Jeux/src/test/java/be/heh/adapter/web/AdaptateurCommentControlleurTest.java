// Importation des classes nécessaires pour les tests
package be.heh.adapter.web;

import be.heh.application.domain.model.Comment;
import be.heh.application.domain.service.CommentService;
import be.heh.port.in.CommentUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Déclaration de la classe de test pour la classe AdaptateurCommentControlleur
public class AdaptateurCommentControlleurTest {

    // Déclaration des variables nécessaires pour les tests
    private AdaptateurCommentControlleur commentController;
    private CommentUseCase commentUseCase;

    // Méthode exécutée avant chaque test pour initialiser les mocks et le controller
    @BeforeEach
    public void setUp() {
        // Configuration initiale pour chaque test
        commentUseCase = mock(CommentService.class);
        commentController = new AdaptateurCommentControlleur(commentUseCase);
    }

    // Test de la méthode createComment
    @Test
    public void createComment_ShouldReturnCreatedComment() {
        // Arrange
        Comment inputComment = new Comment(1, 1, "Great game!", 5, "John Doe");

        // Act
        when(commentUseCase.createComment(inputComment)).thenReturn(inputComment);
        ResponseEntity<Comment> response = commentController.createComment(inputComment);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(inputComment, response.getBody());

        // Vérifie que la méthode createComment a été appelée avec le bon argument
        verify(commentUseCase, times(1)).createComment(inputComment);
    }

    // Test de la méthode createComment en cas d'échec de création du commentaire
    @Test
    public void createComment_ShouldReturnInternalServerError() {
        // Arrange
        Comment inputComment = new Comment(1, 1, "Great game!", 5, "John Doe");

        // Act
        when(commentUseCase.createComment(inputComment)).thenReturn(null);
        ResponseEntity<Comment> response = commentController.createComment(inputComment);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNull(response.getBody());

        // Vérifie que la méthode createComment a été appelée avec le bon argument
        verify(commentUseCase, times(1)).createComment(inputComment);
    }

    // Test de la méthode deleteComment
    @Test
    public void deleteComment_ShouldReturnNoContent() {
        // Arrange
        int commentId = 1;

        // Act
        when(commentUseCase.deleteComment(commentId)).thenReturn(true);
        ResponseEntity<Void> response = commentController.deleteComment(commentId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());

        // Vérifie que la méthode deleteComment a été appelée avec le bon argument
        verify(commentUseCase, times(1)).deleteComment(commentId);
    }

    // Test de la méthode deleteComment en cas d'échec de suppression du commentaire
    @Test
    public void deleteComment_ShouldReturnNotFound() {
        // Arrange
        int commentId = 1;

        // Act
        when(commentUseCase.deleteComment(commentId)).thenReturn(false);
        ResponseEntity<Void> response = commentController.deleteComment(commentId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());

        // Vérifie que la méthode deleteComment a été appelée avec le bon argument
        verify(commentUseCase, times(1)).deleteComment(commentId);
    }

    // Test de la méthode getGameByIdGame
    @Test
    public void getGameByIdGame_ShouldReturnComment() {
        // Arrange
        int gameId = 1;
        Comment expectedComment = new Comment(1, gameId, "Great game!", 5, "John Doe");

        // Act
        when(commentUseCase.getGameByIdGame(gameId)).thenReturn(expectedComment);
        ResponseEntity<Comment> response = commentController.getGameByIdGame(gameId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(expectedComment, response.getBody());

        // Vérifie que la méthode getGameByIdGame a été appelée avec le bon argument
        verify(commentUseCase, times(1)).getGameByIdGame(gameId);
    }

    // Test de la méthode getGameByIdGame en cas d'absence de commentaire pour le jeu
    @Test
    public void getGameByIdGame_ShouldReturnNotFound() {
        // Arrange
        int gameId = 1;

        // Act
        when(commentUseCase.getGameByIdGame(gameId)).thenReturn(null);
        ResponseEntity<Comment> response = commentController.getGameByIdGame(gameId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());

        // Vérifie que la méthode getGameByIdGame a été appelée avec le bon argument
        verify(commentUseCase, times(1)).getGameByIdGame(gameId);
    }
}
