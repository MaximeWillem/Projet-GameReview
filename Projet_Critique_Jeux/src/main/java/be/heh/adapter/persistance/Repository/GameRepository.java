package be.heh.adapter.persistance.Repository;

import be.heh.application.domain.model.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class GameRepository {
    private final JdbcTemplate jdbc;
    public GameRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public void addGameDB(Game game) {
        String sql ="INSERT INTO \"Game\" VALUES (NULL, ?, ?, ?)";
        jdbc.update(sql,
                game.getName(),
                game.getImages(),
                game.getDescription());
    }

    public void deleteGameDB(int gameId) {
        String sql = "DELETE FROM \"Game\" WHERE id = ?";
        jdbc.update(sql, gameId);
    }

    public Game getGameById(int gameId) {
        String sql = "SELECT * FROM \"Game\" WHERE id = ?";
        return jdbc.queryForObject(sql, new Object[]{gameId}, new GameRowMapper());
    }
    public void updateGameDB(Game game) {
        String sql = "UPDATE \"Game\" SET name = ?, image = ?, description = ? WHERE id = ?";
        jdbc.update(sql,
                game.getName(),
                game.getImages(),
                game.getDescription(),
                game.getId());
    }

    public List<Game> getAllGame() {
        String sql = "SELECT * FROM \"Game\"";
        return jdbc.query(sql, new GameRowMapper());
    }
}
