package be.heh.port.in;

import be.heh.application.domain.model.Game;
import be.heh.application.domain.model.User;

import java.util.List;

public interface GameUseCase {
    Game createGame(Game game);
    boolean deleteGame(int gameId);
    Game getGameById(int gameId);
    Game updateGame(Game game);
    List<Game> getAllGame();
}
