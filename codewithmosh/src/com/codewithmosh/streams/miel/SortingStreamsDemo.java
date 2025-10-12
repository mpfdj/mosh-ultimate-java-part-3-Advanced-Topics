package com.codewithmosh.streams.miel;

import com.codewithmosh.streams.Movie;

import java.util.Comparator;
import java.util.List;

public class SortingStreamsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("b", 10),
                new Movie("a", 20),
                new Movie("c", 30)
        );


        // Comparator is a function interface
        movies.stream()
//                .sorted((m1, m2) -> m1.getTitle().compareTo(m2.getTitle()))
//                .sorted(Comparator.comparing(m -> m.getTitle()))
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .forEach(m -> System.out.print(m.getTitle() + " "));
    }

}
