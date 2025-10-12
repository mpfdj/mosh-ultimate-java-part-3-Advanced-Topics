package com.codewithmosh.streams.miel;

import com.codewithmosh.streams.Movie;

import java.util.List;
import java.util.function.Predicate;

public class FilteringElementsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );

        Predicate<Movie> isPopular = movie -> movie.getLikes() > 10;

        movies.stream()
                .filter(isPopular)
                .forEach(movie -> System.out.println(movie.getTitle()));

    }

}
