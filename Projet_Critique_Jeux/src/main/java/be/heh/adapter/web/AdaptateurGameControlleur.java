package be.heh.adapter.web;

import be.heh.application.domain.model.Game;
import be.heh.port.in.GameUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class AdaptateurGameControlleur {
    private final GameUseCase gameUseCase;

    public AdaptateurGameControlleur(GameUseCase gameUseCase) {
        this.gameUseCase= gameUseCase;
    }
    @GetMapping("/game/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable int gameId) {
        Game game = gameUseCase.getGameById(gameId);

        if (game != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(game);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
    @GetMapping("/game")
    public ResponseEntity<List<Game>> getAllGame() {
        List<Game> game = gameUseCase.getAllGame();

        if (!game.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(game);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }



    @DeleteMapping("/game/{gameId}")
    public ResponseEntity<Void> deleteGame(@PathVariable int gameId) {
        boolean deleted = gameUseCase.deleteGame(gameId);

        if (deleted) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }



    @PostMapping("/game")
    public ResponseEntity<Game> createGame(@RequestBody Game gameData) {
        Game createdGame = gameUseCase.createGame(gameData);

        if (createdGame != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdGame);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
    @PutMapping("/game/{gameId}")
    public ResponseEntity<Game> updateGame(@PathVariable int gameId, @RequestBody Game updatedGameData) {
        Game updatedGame = gameUseCase.updateGame(new Game(gameId, updatedGameData.getName(), updatedGameData.getImages(), updatedGameData.getDescription() ));

        if (updatedGame != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(updatedGame);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
