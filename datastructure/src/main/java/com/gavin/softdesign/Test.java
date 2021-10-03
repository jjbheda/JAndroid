package com.gavin.softdesign;

class Test {
    public static void main(String[] args) {

        User1 user1 = new User1();
        User2 user2 = new User2();

        Observer observer = new Observer();
        observer.register(user1);
        observer.register(user2);

        observer.notify("msg from observer");
    }
}

