package com.codewithmosh.streams.miel;

import com.codewithmosh.streams.Movie;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class MappingElementsDemo {

    public static void main(String[] args) {

        // map example
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );

        // Print titles
//        movies.stream()
//                .map(movie -> movie.getTitle())
//                .forEach(title -> System.out.println(title));

        movies.stream()
                .map(Movie::getTitle)
                .forEach(System.out::println);

        // Print likes
        movies.stream()
                .mapToInt(Movie::getLikes)
                .forEach(System.out::println);


        // flatmap example
        // Stream<List<x>> -> Stream<x>
        var stream = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));

//        stream.flatMap(list -> list.stream())
//                .forEach(number -> System.out.print(number + " "));

        stream.flatMap(Collection::stream)
                .forEach(number -> System.out.print(number + " "));


        System.out.println();

        // same goes for list of objects
        var movies1 = List.of(new Movie("a", 10), new Movie("b", 20), new Movie("c", 30));
        var movies2 = List.of(new Movie("d", 10), new Movie("e", 20));

        var moviesStream = Stream.of(movies1, movies2);

        moviesStream.flatMap(Collection::stream)
                .forEach(m -> System.out.print(m.getTitle() + " "));


    }

}
