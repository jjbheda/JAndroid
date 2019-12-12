package com.gavin;

public class CommonGenericMethod {

    public <T> T genericMethod(T ...a) {
        return a[a.length/2];
    }

    public void test(int x, int y) {
        System.out.println(x + y);
    }

    public static void main(String[] args) {
        CommonGenericMethod method = new CommonGenericMethod();
        method.test(100,101);
        System.out.println(method.<String>genericMethod("hello","word","gavin"));
        System.out.println(method.genericMethod("hello","word","gavin"));   //新版编辑器支持
        System.out.println(method.genericMethod(20,30,40,"hello word ","你好","你好")); //不建议这样混用
    }

}
