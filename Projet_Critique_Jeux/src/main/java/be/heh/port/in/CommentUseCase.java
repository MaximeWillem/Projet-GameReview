package be.heh.port.in;

import be.heh.application.domain.model.Comment;

public interface CommentUseCase {
    Comment createComment(Comment comment);
    boolean deleteComment(int commentId);

    Comment getGameByIdGame(int gameId);
}
