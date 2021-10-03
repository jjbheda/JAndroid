package com.gavin.datastructure.多线程相关;

import java.util.concurrent.Semaphore;

class 交替打印FooBar {
        private int n;
        public 交替打印FooBar(int n) {
            this.n = n;
        }

        private Semaphore foo = new Semaphore(1);
        private Semaphore bar = new Semaphore(1);

        public  void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                foo.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                bar.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                foo.release();
            }
        }

        class A implements Runnable{
                @Override
                public void run() {
                    System.out.println("foo");
                }
            }

        class B implements Runnable{

            @Override
            public void run() {
                System.out.println("bar");
            }
        }

    // 方法1 信息量

    public static void main(String[] args) {
        final 交替打印FooBar test = new 交替打印FooBar(10);
        final A a =  test.new A();
        final B b =  test.new B();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.foo(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.bar(b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
