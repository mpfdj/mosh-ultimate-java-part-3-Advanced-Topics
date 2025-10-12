package com.codewithmosh.streams.miel;

import com.codewithmosh.streams.Movie;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );

        // key (title)
        // value (likes)
        var result1 = movies.stream()
                .filter(m -> m.getLikes() > 10)
//                .collect(Collectors.toMap(m -> m.getTitle(), m -> m.getLikes()));
                .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));

        System.out.println(result1);


        // key (title)
        // value (Movie)
        var result2 = movies.stream()
                .filter(m -> m.getLikes() > 10)
//                .collect(Collectors.toMap(Movie::getTitle, m ->m));
                .collect(Collectors.toMap(Movie::getTitle, Function.identity()));

        System.out.println(result2);


        // use summyInt method instead of using reduce method
        var sum = movies.stream()
                .filter(m -> m.getLikes() > 10)
//                .collect(Collectors.summingInt(Movie::getLikes));
                .mapToInt(Movie::getLikes).sum();
        System.out.println("sum: " + sum);


        // using summary now
        var summary = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));
        System.out.println("summary: " + summary);


        // concatenate titles
        var titles = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));
        System.out.println("titles: " + titles);



    }

}
