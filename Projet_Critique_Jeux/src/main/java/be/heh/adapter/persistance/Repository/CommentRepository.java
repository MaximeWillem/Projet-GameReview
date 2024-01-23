package be.heh.adapter.persistance.Repository;

import be.heh.application.domain.model.Comment;
import be.heh.application.domain.model.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {
    private final JdbcTemplate jdbc;
    public CommentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public void addCommentDB(Comment comment) {
        String sql ="INSERT INTO \"Comment\" VALUES (NULL, ?, ?, ?, ?)";
        jdbc.update(sql,
                comment.getGameId(),
                comment.getContent(),
                comment.getRating(),
                comment.getAuthor());

    }
    public void deleteCommentDB(int commentId) {
        String sql = "DELETE FROM \"Comment\" WHERE id = ?";
        jdbc.update(sql, commentId);
    }

    public Comment getCommentbyId(int gameId) {
        String sql = "SELECT * FROM \"Comment\" WHERE id = ?";
        return jdbc.queryForObject(sql, new Object[]{gameId}, new CommentRowMapper());
    }
}
