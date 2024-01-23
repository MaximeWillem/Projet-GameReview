package be.heh.adapter.persistance.persistance;
import be.heh.adapter.persistance.Repository.GameRepository;
import be.heh.application.domain.model.Game;
import be.heh.port.out.GamePersistance;


import java.util.List;

public class AdaptateurGamePersistance implements GamePersistance {
    private GameRepository gameRepository;

    public AdaptateurGamePersistance(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    @Override
    public void updateGameDB(Game game) {
        gameRepository.updateGameDB(game);
    }

    @Override
    public void addGameDB(Game game) {
        gameRepository.addGameDB(game);
    }

    @Override
    public void deleteGameDB(int gameId) {
        gameRepository.deleteGameDB(gameId);
    }

    @Override
    public Game getGameById(int gameId) {
        return gameRepository.getGameById(gameId);
    }

    @Override
    public List<Game> getAllGame() {
        return gameRepository.getAllGame();
    }
}



