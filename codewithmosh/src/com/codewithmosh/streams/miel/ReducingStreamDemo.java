package com.codewithmosh.streams.miel;

import com.codewithmosh.streams.Movie;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class ReducingStreamDemo {


    // Reduce a stream into a single value


    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );

        // [10, 20, 30]
        // [30, 30]
        // [60]

        // using primitive version
        OptionalInt sum1 = movies.stream()
                .mapToInt(Movie::getLikes)
//                .reduce((a, b) -> a + b);
                .reduce(Integer::sum);

        System.out.println("sum1: " + sum1.orElse(0));



        Optional<Integer> sum2 = movies.stream()
                .map(Movie::getLikes)
                .reduce(Integer::sum);

        System.out.println("sum2: " + sum1.orElse(0));


        // using a default value (identity arg)
        // now the reduce method returns an Integer instead of an Option<Integer>

        Integer sum3 = movies.stream()
                .map(Movie::getLikes)
                .reduce(0, Integer::sum);

        System.out.println("sum3: " + sum3);
    }

}
