package be.heh.port.out;

import be.heh.application.domain.model.Comment;
import be.heh.application.domain.model.Game;
import be.heh.application.domain.model.User;

import java.util.List;

public interface CommentPersistance {
    void addCommentDB(Comment comment);
    void deleteCommentDB(int commentId);

    Comment getCommentByIdGameDB(int gameId);

}
