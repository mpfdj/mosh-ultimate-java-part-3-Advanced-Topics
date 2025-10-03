package com.codewithmosh.generics.miel;

public class Kim extends Person {
    private static final String NAME = "Kim";
    private static final int AGE = 16;

    public Kim() {
        super(NAME, AGE);
    }

    public void doHobby() {
        System.out.println(NAME + " is playing volleyball");
    }
}
