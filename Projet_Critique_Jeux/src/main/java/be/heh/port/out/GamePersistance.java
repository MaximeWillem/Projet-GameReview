package be.heh.port.out;

import be.heh.application.domain.model.Game;
import be.heh.application.domain.model.User;

import java.util.List;

public interface GamePersistance {
    void addGameDB(Game game);
    void deleteGameDB(int gameId);
    void updateGameDB(Game game);
    Game getGameById(int gameId);
    List<Game> getAllGame();
}
