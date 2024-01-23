package be.heh.application.domain.service;

import be.heh.application.domain.model.Comment;
import be.heh.port.out.CommentPersistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de tests pour la classe CommentService.
 */
public class CommentServiceTest {
    private CommentService commentService;
    private CommentPersistance commentPersistance;

    @BeforeEach
    public void setUp() {
        // Configuration initiale pour chaque test
        commentPersistance = mock(CommentPersistance.class);
        commentService = new CommentService(commentPersistance);
    }

    @Test
    public void createComment_ShouldReturnCreatedComment() {
        // Arrange
        // Mise en place des données d'entrée
        Comment inputComment = new Comment(1, 1, "Super jeu !", 5, "John Doe");

        // Act
        // Exécution de la méthode à tester
        doNothing().when(commentPersistance).addCommentDB(inputComment);
        Comment createdComment = commentService.createComment(inputComment);

        // Assert
        // Vérification des résultats
        assertNotNull(createdComment);
        assertEquals(inputComment, createdComment);

        // Vérifie que la méthode addCommentDB a été appelée avec le bon argument
        verify(commentPersistance, times(1)).addCommentDB(inputComment);
    }

    @Test
    public void deleteComment_ShouldReturnTrue() {
        // Arrange
        // Mise en place des données d'entrée
        int commentId = 1;

        // Act
        // Exécution de la méthode à tester
        doNothing().when(commentPersistance).deleteCommentDB(commentId);
        boolean result = commentService.deleteComment(commentId);

        // Assert
        // Vérification des résultats
        assertTrue(result);

        // Vérifie que la méthode deleteCommentDB a été appelée avec le bon argument
        verify(commentPersistance, times(1)).deleteCommentDB(commentId);
    }

    @Test
    public void getCommentByIdGame_ShouldReturnComment() {
        // Arrange
        // Mise en place des données d'entrée
        int gameId = 1;
        Comment expectedComment = new Comment(1, gameId, "Super jeu !", 5, "John Doe");

        // Act
        // Exécution de la méthode à tester
        when(commentPersistance.getCommentByIdGameDB(gameId)).thenReturn(expectedComment);
        Comment retrievedComment = commentService.getGameByIdGame(gameId);

        // Assert
        // Vérification des résultats
        assertNotNull(retrievedComment);
        assertEquals(expectedComment, retrievedComment);
    }
}
