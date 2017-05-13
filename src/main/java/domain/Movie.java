package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vpnk on 03.05.17.
 */
public class Movie extends DataTemplate{
    private int id;
    private String title;
    private List<Comment> comments = new ArrayList<Comment>();
    private List<Actor> actors = new ArrayList<Actor>();
    private Integer rating = 0;

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void addRating(int rating) {
        this.rating = (this.rating + rating) / 2;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
    }
}
