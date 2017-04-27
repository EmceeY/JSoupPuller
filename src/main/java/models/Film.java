package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by User on 4/26/17.
 */

@Entity
public class Film {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String title;

    private String year;

    private String type;

    private String genre;

    //not on most films
    private String actors;

    private String imdbRating;

    private String netflixRating;

    //not on most films
    private String length;

    private String poster;

    private String description;

    public Film(String title, String year, String type, String genre, String imdbRating,
                String netflixRating, String poster, String description){
        this.title = title;
        this.year = year;
        this.type = type;
        this.genre = genre;
        this.imdbRating = imdbRating;
        this.netflixRating = netflixRating;
        this.poster = poster;
        this.description = description;
    }

    //overloaded constructor for films that have more information than the norm
    public Film(String title, String year, String type, String genre, String actors, String imdbRating,
                String netflixRating, String length, String poster, String description){
        this.title = title;
        this.year = year;
        this.type = type;
        this.genre = genre;
        this.actors = actors;
        this.imdbRating = imdbRating;
        this.netflixRating = netflixRating;
        this.length = length;
        this.poster = poster;
        this.description = description;
    }

    //empty constructor for Hibernate
    public Film() { }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getNetflixRating() {
        return netflixRating;
    }

    public void setNetflixRating(String netflixRating) {
        this.netflixRating = netflixRating;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
