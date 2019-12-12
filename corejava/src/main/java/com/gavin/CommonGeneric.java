package com.gavin;

public class CommonGeneric<T> {
    private T data;

    public CommonGeneric(T data) {
        this.data = data;
    }

    public CommonGeneric() {

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public <T,E> T test(E a) {
        return null;
    }

    public static void main(String[] args) {
        CommonGeneric<String> commonGeneric = new CommonGeneric<>();
        commonGeneric.setData("Hello World");
        System.out.println(commonGeneric.getData());
    }
}
