package com.codewithmosh.streams.miel;

import com.codewithmosh.streams.Movie;

import java.util.List;

public class SlicingStreamsDemo {

    public static void main(String[] args) {

//        limit(n)
//        skip(n)
//        takeWhile(predicate)
//        dropWhile(predicate)


        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 30),
                new Movie("c", 20)
        );

        // limit first 2
        movies.stream()
                .limit(2)
                .forEach(movie -> System.out.print(movie.getTitle() + " "));

        System.out.println();

        // skip first 2
        movies.stream()
                .skip(2)
                .forEach(movie -> System.out.print(movie.getTitle() + " "));

        System.out.println();

        // example on pagination
        // 1000 movies
        // 10 movies per page
        // 3rd page
        // skip 20  = skip((page - 1) x pageSize)
        // limit 10 = limit(pageSize)
        movies.stream()
                .skip(20)
                .limit(10)
                .forEach(movie -> System.out.print(movie.getTitle() + " "));

        System.out.println();

        // takeWhile is different from filter method
        // it stops when the Predicate is true
        // where filter processes the whole list
        movies.stream()
                .takeWhile(movie -> movie.getLikes() < 30)
                .forEach(movie -> System.out.print(movie.getTitle() + " "));

        System.out.println();

        movies.stream()
                .filter(movie -> movie.getLikes() < 30)
                .forEach(movie -> System.out.print(movie.getTitle() + " "));

        System.out.println();

        // dropWhile
        movies.stream()
                .dropWhile(movie -> movie.getLikes() < 30)
                .forEach(movie -> System.out.print(movie.getTitle() + " "));
    }

}
