package com.ziker0k.lesson28;

import com.ziker0k.lesson28.model.User;

public class ReflectionApiExample {
    public static void main(String[] args) {
        User bob = new User(15L, "Bob", 19);
        Class<? extends User> bobClass = bob.getClass();
        Class<User> userClass = User.class;
        System.out.println(bobClass == userClass);
    }
}
