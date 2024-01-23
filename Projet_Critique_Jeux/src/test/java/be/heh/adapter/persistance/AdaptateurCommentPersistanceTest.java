package be.heh.adapter.persistance;// Importation des classes nécessaires pour les tests
import be.heh.adapter.persistance.Repository.CommentRepository;
import be.heh.adapter.persistance.persistance.AdaptateurCommentPersistance;
import be.heh.application.domain.model.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Déclaration de la classe de test pour AdaptateurCommentPersistance
public class AdaptateurCommentPersistanceTest {

    // Déclaration des variables nécessaires pour les tests
    private CommentRepository commentRepository;
    private AdaptateurCommentPersistance commentPersistance;

    // Méthode exécutée avant chaque test pour initialiser les mocks et l'objet à tester
    @BeforeEach
    public void setUp() {
        // Configuration initiale pour chaque test
        commentRepository = mock(CommentRepository.class);
        commentPersistance = new AdaptateurCommentPersistance(commentRepository);
    }

    // Test de la méthode addCommentDB
    @Test
    public void addCommentDB_ShouldDelegateToRepository() {
        // Arrange
        Comment inputComment = new Comment(1, 1, "Great game!", 5, "John Doe");

        // Act
        // Exécution de la méthode à tester
        commentPersistance.addCommentDB(inputComment);

        // Assert
        // Vérification que la méthode addCommentDB du repository a été appelée avec le bon argument
        verify(commentRepository, times(1)).addCommentDB(inputComment);
    }

    // Test de la méthode deleteCommentDB
    @Test
    public void deleteCommentDB_ShouldDelegateToRepository() {
        // Arrange
        int commentId = 1;

        // Act
        // Exécution de la méthode à tester
        commentPersistance.deleteCommentDB(commentId);

        // Assert
        // Vérification que la méthode deleteCommentDB du repository a été appelée avec le bon argument
        verify(commentRepository, times(1)).deleteCommentDB(commentId);
    }

    // Test de la méthode getCommentByIdGameDB
    @Test
    public void getCommentByIdGameDB_ShouldDelegateToRepository() {
        // Arrange
        int gameId = 1;
        Comment expectedComment = new Comment(1, gameId, "Great game!", 5, "John Doe");
        when(commentRepository.getCommentbyId(gameId)).thenReturn(expectedComment);

        // Act
        // Exécution de la méthode à tester
        Comment retrievedComment = commentPersistance.getCommentByIdGameDB(gameId);

        // Assert
        // Vérification que la méthode getCommentbyId du repository a été appelée avec le bon argument
        verify(commentRepository, times(1)).getCommentbyId(gameId);

        // Vérification des résultats
        assertNotNull(retrievedComment);
        assertEquals(expectedComment, retrievedComment);
    }
}
