package domain;

import java.util.List;

/**
 * Created by vpnk on 03.05.17.
 */
public class Actor extends DataTemplate{
    private int id;
    private String name;
    private String surname;
    private List<Movie> movies;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    public void addMovie(Movie movie){
        movies.add(movie);
    }
}
