package be.heh.adapter.persistance.Repository;

import be.heh.application.domain.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        return new User(id, username, password);
    }
}
