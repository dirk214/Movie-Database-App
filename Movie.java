package com.example.dirk2.moviedatabase;
import java.util.Comparator;
import java.util.Arrays;

/**
 * Created by dirk2 on 3/18/2018.
 */

public class Movie implements Comparable<Movie>, java.io.Serializable {

    private int voteCount;
    private int id;
    private boolean video;
    private double vote_average;
    private String title;
    private double popularity;
    private String posterpath;
    private String originalLanguage;
    private String originalTitle;
    private String genre_ids;
    private String backdropPath;
    private boolean adult;
    private String overview;
    private String releaseDate;

    public Movie(int voteCount, int id, boolean video, double vote_average, String title, double popularity, String posterpath,
                 String originalLanguage, String originalTitle, String genre_ids, String backdropPath, boolean adult,
                 String overview, String releaseDate) {
        this.voteCount = voteCount; this.id = id; this.video = video; this.vote_average = vote_average; this.title = title;
        this.popularity = popularity; this.posterpath = posterpath; this.originalLanguage = originalLanguage; this. originalTitle = originalTitle;
        this.genre_ids = genre_ids; this.backdropPath = backdropPath; this.adult = adult; this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public int getVoteCount() {
        return this.voteCount;
    }

    public int getId() {
        return this.id;
    }
    public boolean getVideo() {
        return this.video;
    }
    public double getVote_average() {
        return this.vote_average;
    }
    public String getTitle() {
        return this.title;
    }
    public double getPopularity() {
        return this.popularity;
    }
    public String getPosterpath() {
        return this.posterpath;
    }
    public String getOriginalLanguage() {
        return this.originalLanguage;
    }
    public String getOriginalTitle() {
        return this.originalTitle;
    }
    public String getGenre_ids() {
        return this.genre_ids;
    }
    public String getBackdropPath() {
        return this.backdropPath;
    }
    public boolean getAdult() {
        return this.adult;
    }
    public String getOverview() {
        return this.overview;
    }
    public String getReleaseDate() {
        return this.releaseDate;
    }

    public String toString() {
        String ret = "";
        ret+= "Vote Count: " + this.voteCount + ":\n";
        ret+= "ID: " + this.id + ":\n";
        ret+= "Video: " + this.video + ":\n";
        ret+= "Vote Average: " + this.vote_average + ":\n";
        ret+= "Title: " + this.title + ":\n";
        ret+= "Popularity: " + this.popularity + ":\n";
        ret+= "PosterPath: " + this.posterpath + ":\n";
        ret+= "Original Language: " + this.originalLanguage + ":\n";
        ret+= "Original Title: " + this.originalTitle + ":\n";
        ret+= "Genre Ids: " + this.genre_ids + ":\n";
        ret+= "Backdrop Path: " + this.backdropPath + ":\n";
        ret+= "Adult: " + this.adult + ":\n";
        ret+= "Overview: " + this.overview + ":\n";
        ret+= "Release Date: " + this.releaseDate + ":\n";
        return ret;
    }

    public int compareTo(Movie movie) {
        return (int) (movie.getVote_average() * 100) - (int) (this.getVote_average() * 100);
    }

}
