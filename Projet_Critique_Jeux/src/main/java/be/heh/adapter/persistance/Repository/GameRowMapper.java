package be.heh.adapter.persistance.Repository;

import be.heh.application.domain.model.Game;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class GameRowMapper implements RowMapper<Game> {

    @Override
    public Game mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String image = resultSet.getString("image");
        String description = resultSet.getString("description");
        return new Game(id, name, image, description);
    }
}