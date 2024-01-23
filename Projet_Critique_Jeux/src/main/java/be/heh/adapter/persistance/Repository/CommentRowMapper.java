package be.heh.adapter.persistance.Repository;

import be.heh.application.domain.model.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("id");
        int gameId = resultSet.getInt("gameId");
        String content = resultSet.getString("content");
        int rating = resultSet.getInt("rating");
        String author = resultSet.getString("author");
        return new Comment(id, gameId, content, rating, author);
    }

}