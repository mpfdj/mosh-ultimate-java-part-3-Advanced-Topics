package com.codewithmosh.collections;

import java.util.*;

public class SetDemo {
  public static void show() {
    Set<String> set1;
    Set<String> set2;

    // Union
    set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
    set2 = new HashSet<>(Arrays.asList("b", "c", "d"));
    set1.addAll(set2);
    System.out.println(set1);

    // Intersection
    set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
    set2 = new HashSet<>(Arrays.asList("b", "c", "d"));
    set1.retainAll(set2);
    System.out.println(set1);

    // Difference
    set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
    set2 = new HashSet<>(Arrays.asList("b", "c", "d"));
    set1.removeAll(set2);
    System.out.println(set1);
  }
}
