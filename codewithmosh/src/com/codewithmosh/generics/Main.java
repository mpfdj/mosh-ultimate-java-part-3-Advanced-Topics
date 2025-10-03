package com.codewithmosh.generics;

public class Main {

    public static void main(String[] args) {
        var user1 = new User(100);
        var user2 = new User(200);
        var instructor1 = new Instructor(300);
        var instructor2 = new Instructor(400);

        GenericList<User> userList = new GenericList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(instructor1);
        userList.add(instructor2);


        var max = Utils.max(user1, instructor1);
        System.out.println("max: " + max);


        Utils.print("hello", 100);

        Utils.printUser(user1);

        Utils.printUsers(userList);

    }

}
