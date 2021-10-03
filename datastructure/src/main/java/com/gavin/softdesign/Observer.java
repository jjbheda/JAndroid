package com.gavin.softdesign;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class Observer {
    public Observer(){}

    private ArrayList<IObserver> array = new ArrayList<>();

    public void register(IObserver callback) {
        array.add(callback);
    }

    public void notify(String msg) {
        for (IObserver observer : array) {
            observer.update(msg);
        }
    }
}
