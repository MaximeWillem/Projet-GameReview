package be.heh.application.domain.model;

public class Game {
    private int id;
    private String name;
    private String images;
    private String description;

    public Game(int id, String name, String images, String description) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

}
