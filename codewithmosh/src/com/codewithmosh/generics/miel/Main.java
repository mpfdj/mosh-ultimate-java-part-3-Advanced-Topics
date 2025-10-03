package com.codewithmosh.generics.miel;

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




}