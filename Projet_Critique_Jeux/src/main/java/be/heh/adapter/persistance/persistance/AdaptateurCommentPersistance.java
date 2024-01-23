package be.heh.adapter.persistance.persistance;
import be.heh.adapter.persistance.Repository.CommentRepository;
import be.heh.application.domain.model.Comment;
import be.heh.application.domain.model.Game;
import be.heh.port.out.CommentPersistance;
import org.springframework.stereotype.Component;

import java.util.List;

public class AdaptateurCommentPersistance implements CommentPersistance {
    private CommentRepository commentRepository;

    public AdaptateurCommentPersistance(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @Override
    public void addCommentDB(Comment comment) {
        commentRepository.addCommentDB(comment);
    }

    @Override
    public void deleteCommentDB(int commentId) {
        commentRepository.deleteCommentDB(commentId);
    }

    @Override
    public Comment getCommentByIdGameDB(int gameId) {
        return commentRepository.getCommentbyId(gameId);
    }



}




