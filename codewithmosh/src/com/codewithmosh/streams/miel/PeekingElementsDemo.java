package com.codewithmosh.streams.miel;

import com.codewithmosh.streams.Movie;

import java.util.List;

public class PeekingElementsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );


        // use peek() method for debugging streams
        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .peek(m -> System.out.println("filtered: " + m.getTitle()))
                .map(Movie::getTitle)
                .peek(t -> System.out.println("mapped: " + t))
                .forEach(System.out::println);
    }

}
