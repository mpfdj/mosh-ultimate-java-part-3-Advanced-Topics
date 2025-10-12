package com.codewithmosh.streams.miel;

import com.codewithmosh.streams.Genre;
import com.codewithmosh.streams.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class PartitioningElementsDemo {

// While partitioningBy() is great for splitting data into two groups, it may not always be the most efficient choice.
// In cases where data needs to be divided into more than two categories, consider using other methods such as Collectors.
// groupingBy() or manually filtering the stream.

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );


        var result = movies.stream()
                .collect(Collectors.partitioningBy(
                        m -> m.getLikes() > 20,
                        Collectors.mapping(
                                Movie::getTitle,
                                Collectors.joining(", "))));

        System.out.println(result);


        var result2 = movies.stream()
                .collect(Collectors.partitioningBy(
                        m -> m.getLikes() > 20,
                        Collectors.toList()));
        System.out.println(result2);
    }
}
