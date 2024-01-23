package be.heh.application.domain.service;

import be.heh.application.domain.model.Game;
import be.heh.application.domain.model.User;
import be.heh.port.in.GameUseCase;
import be.heh.port.out.GamePersistance;
import be.heh.port.out.UserPersistance;
import org.springframework.stereotype.Service;

import java.util.List;

public class GameService implements GameUseCase {
    private final GamePersistance gamePersistance;

    public GameService(GamePersistance gamePersistance) {
        this.gamePersistance = gamePersistance;
    }

    @Override
    public Game createGame(Game game) {
        gamePersistance.addGameDB(game);
        return game;
    }

    @Override
    public boolean deleteGame(int gameId) {
        gamePersistance.deleteGameDB(gameId);
        return true;
    }

    @Override
    public Game getGameById(int gameId) {
        return gamePersistance.getGameById(gameId);
    }

    @Override
    public List<Game> getAllGame() {
        return gamePersistance.getAllGame();
    }

    @Override
    public Game updateGame(Game game) {
        gamePersistance.updateGameDB(game);
        return game;
    }
}
