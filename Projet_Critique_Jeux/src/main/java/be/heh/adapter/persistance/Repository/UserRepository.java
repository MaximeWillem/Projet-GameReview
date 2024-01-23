package be.heh.adapter.persistance.Repository;

import be.heh.application.domain.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
        private final JdbcTemplate jdbc;
        public UserRepository(JdbcTemplate jdbc) {
            this.jdbc = jdbc;
        }
        public void addUserDB(User user) {
            String sql ="INSERT INTO \"User\" VALUES (NULL, ?, ?)";
            jdbc.update(sql,
                    user.getUsername(),
                    user.getPassword());
            }

        public void deleteUserDB(int userId) {
            String sql = "DELETE FROM \"User\" WHERE id = ?";
            jdbc.update(sql, userId);
        }

        public User getUserById(int userId) {
            String sql = "SELECT * FROM \"User\" WHERE id = ?";
            return jdbc.queryForObject(sql, new Object[]{userId}, new UserRowMapper());
        }
        public void updateUserDB(User user) {
            String sql = "UPDATE \"User\" SET username = ?, password = ? WHERE id = ?";
            jdbc.update(sql,
                    user.getUsername(),
                    user.getPassword(),
                    user.getId());
        }

        public List<User> getAllUsers() {
            String sql = "SELECT * FROM \"User\"";
            return jdbc.query(sql, new UserRowMapper());
        }
}

