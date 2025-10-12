package com.codewithmosh.streams.miel;

import com.codewithmosh.streams.Movie;

import java.util.Comparator;
import java.util.List;

public class SimpleReducersDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );


        var count = movies.stream().count();
        System.out.println("count: " + count);


        boolean isMatch;

        isMatch = movies.stream()
                .anyMatch(m -> m.getLikes() > 20);
        System.out.println("anyMatch: " + isMatch);

        isMatch = movies.stream()
                .allMatch(m -> m.getLikes() > 20);
        System.out.println("allMatch: " + isMatch);

        isMatch = movies.stream()
                .noneMatch(movie -> movie.getLikes() > 20);
        System.out.println("noneMatch: " + isMatch);



        Movie movie;

        movie = movies.stream()
                .findFirst()
                .get();
        System.out.println("findFirst: " + movie.getTitle());

        movie = movies.stream()
                .findAny()
                .get();
        System.out.println("findAny: " + movie.getTitle());


        var movieWithMaxLikes = movies.stream()
                .max(Comparator.comparing(Movie::getLikes))
                .get();
        System.out.println("max: " + movieWithMaxLikes);

    }

}
