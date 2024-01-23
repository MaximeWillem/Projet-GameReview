package be.heh.application.domain.model;
import java.util.Objects;
import be.heh.application.domain.model.User;

public class Comment {
    private int id;
    private int gameId;
    private String content;
    private int rating;
    private String author;

    public Comment(int id, int gameId, String content, int rating, String author) {
        this.id = id;
        this.gameId = gameId;
        this.content = content;
        this.rating = rating;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public int getGameId() {
        return gameId;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



}
