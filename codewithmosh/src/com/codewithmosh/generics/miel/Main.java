package com.codewithmosh.generics.miel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        print(1_000); // Boxing
        print(1.23f); // Boxing

        byte b = 1;
        print(b); // Boxing


        Miel miel = new Miel();
        Kim kim = new Kim();
        Human human = new Human();

        printPerson(miel);
        printPerson(kim);

        printHuman(human);


        String age = (miel.compareTo(kim) == 0) ? "same" : "different";
        System.out.println(miel.getName() + " and kim " + kim.getName() + " have " + age + " age");


        var intList = List.of(1, 2, 3, 4, 5);
        System.out.println("Average is: " + getAverage(intList));

        var doubleList = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
        System.out.println("Average is: " + getAverage(doubleList));


        List<Integer> intList2 = new ArrayList<>(intList);
        appendToList(intList2);
        System.out.println(intList2);

        List<Number> numberList2 = new ArrayList<>(doubleList);
        appendToList(numberList2);
        System.out.println(numberList2);


//        List<Double> doubleList2 = new ArrayList<>(doubleList);
//        appendToList(doubleList2);
//        System.out.println(doubleList2);


    }



    // Some examples using generics with constrains (UpperBound)


    public static <T extends Number> void print(T number) {
        String type = number.getClass().getName();
        System.out.println("Number is: " + number + " is of type: " + type );
    }

    // Two constrains (class comes before interface) using & sign
    public static <T extends Person & Comparable<Person>> void printPerson(T person) {
        System.out.println("Name is "+ person.getName());
        System.out.println("Age is "+ person.getAge());
        person.walk();
    }

    public static <T extends Human> void printHuman(T human) {
        human.walk();
    }


    public static double getAverage(List <? extends Number> listOfNumbers) {
        double sum = 0;
        for (Number number : listOfNumbers) {
            sum += number.doubleValue();
        }
        return sum / listOfNumbers.size();
    }


    public static void appendToList(List<? super Integer> intList) {
        intList.add(6);
    }


}