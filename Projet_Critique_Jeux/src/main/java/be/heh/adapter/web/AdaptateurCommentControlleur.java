package be.heh.adapter.web;

import be.heh.application.domain.model.Comment;
import be.heh.application.domain.model.Game;
import be.heh.application.domain.service.CommentService;
import be.heh.port.in.CommentUseCase;
import be.heh.port.in.GameUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class AdaptateurCommentControlleur {

    private final CommentUseCase commentUseCase;

    public AdaptateurCommentControlleur(CommentUseCase commentUseCase) {
        this.commentUseCase = commentUseCase;
    }
    @PostMapping("/comment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment commentData) {
        Comment createdComment = commentUseCase.createComment(commentData);

        if (createdComment != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdComment);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable int commentId) {
        boolean deleted = commentUseCase.deleteComment(commentId);

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
    @GetMapping("/comment/{gameId}")
    public ResponseEntity<Comment> getGameByIdGame(@PathVariable int gameId) {
        Comment comment = commentUseCase.getGameByIdGame(gameId);

        if (comment != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(comment);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
