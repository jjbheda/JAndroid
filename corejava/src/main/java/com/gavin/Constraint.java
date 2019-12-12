package com.gavin;

public class Constraint<T> {
    private T data;

    public Constraint(T data) {
// this.data = new T();  不允许实例化
    }

//public static T intance;  静态域或者普通方法里不能引用类型变量

    //静态方法 本身是泛型方法 可以使用
    private static <T> T getInstance() {
        return null;
    }


}
