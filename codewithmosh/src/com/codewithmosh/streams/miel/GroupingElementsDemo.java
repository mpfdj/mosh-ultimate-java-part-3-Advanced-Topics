package com.codewithmosh.streams.miel;

import com.codewithmosh.streams.Genre;
import com.codewithmosh.streams.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class GroupingElementsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );

        var result = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
        System.out.println(result);


        // get number of movies per Genre
        var numberOfMoviesPerGenre = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.counting()));
        System.out.println(numberOfMoviesPerGenre);


        // concatenate Movie titles
        var titles = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.mapping(
                                Movie::getTitle,
                                Collectors.joining(", "))));
        System.out.println(titles);
    }

}
