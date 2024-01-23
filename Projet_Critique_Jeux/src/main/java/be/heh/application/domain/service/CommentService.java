package be.heh.application.domain.service;

import be.heh.application.domain.model.Comment;
import be.heh.application.domain.model.Game;
import be.heh.port.in.CommentUseCase;
import be.heh.port.out.CommentPersistance;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class CommentService implements CommentUseCase {
    private final CommentPersistance commentPersistance;

    public CommentService(CommentPersistance commentPersistance) {
        this.commentPersistance = commentPersistance;
    }

    @Override
    public Comment createComment(Comment comment) {
        commentPersistance.addCommentDB(comment);
        return comment;
    }

    @Override
    public boolean deleteComment(int commentId) {
        commentPersistance.deleteCommentDB(commentId);
        return true;
    }

    @Override
    public Comment getGameByIdGame(int gameId) {
        return commentPersistance.getCommentByIdGameDB(gameId);
    }



}
