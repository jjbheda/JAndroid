package com.gavin.softdesign;

class User2 implements IObserver{
    @Override
    public void update(String msg) {
        System.out.println(msg);
    }
}
