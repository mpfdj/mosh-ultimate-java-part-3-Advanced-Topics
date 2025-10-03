package com.codewithmosh.generics.miel;

public class Miel extends Person {
    private static final String NAME = "Miel";
    private static final int AGE = 45;

    public Miel() {
        super(NAME, AGE);
    }

    public void doHobby() {
        System.out.println(NAME + " is DJ-ing");
    }
}
