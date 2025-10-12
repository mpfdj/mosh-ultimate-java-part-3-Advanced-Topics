package com.codewithmosh.streams.miel;

import com.codewithmosh.streams.Movie;

import java.util.List;

public class GettingUniqueElementsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );

        // https://medium.com/@AlexanderObregon/javas-stream-distinct-method-explained-a2ce1c44638e
        // The Stream.distinct() method in Java offers a straightforward way to filter out duplicate elements in streams, making it a practical tool for data deduplication tasks.
        // By relying on equals() and hashCode() implementations, distinct() effectively identifies unique elements, whether in simple data types or custom objects.
        // While it may add some memory overhead, distinct() provides a quick solution for managing duplicates, especially when working with large collections.
        // distinct Movie objects
        movies.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        // distinct single field
        movies.stream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println);

    }
}
