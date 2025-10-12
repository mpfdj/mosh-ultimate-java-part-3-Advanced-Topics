package com.codewithmosh.streams;

import java.util.Objects;

public class Movie implements Comparable<Movie> {
    private String title;
    private int likes;
    private Genre genre;

    public Movie(String title, int likes) {
        this.title = title;
        this.likes = likes;
    }

    public Movie(String title, int likes, Genre genre) {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public int compareTo(Movie other) {
        return 0;
//        return Integer.compare(other.likes, this.likes);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", likes=" + likes +
                ", genre=" + genre +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Movie movie)) return false;
        return likes == movie.likes && Objects.equals(title, movie.title) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, likes, genre);
    }
}
