package com.gavin.datastructure.多线程相关;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *
 * 一个将会调用 first() 方法
 * 一个将会调用 second() 方法
 * 还有一个将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class 按序打印 {
    AtomicInteger atomicInteger_01 = new AtomicInteger();
    AtomicInteger atomicInteger_02 = new AtomicInteger();

    public void first(Runnable printFirst) {
        printFirst.run();
        atomicInteger_01.incrementAndGet();
    }

    public void second(Runnable printSecond) {
        while (atomicInteger_01.get() != 1) {

        }
        printSecond.run();
        atomicInteger_02.incrementAndGet();
    }

    public void three(Runnable printThree) {
        while (atomicInteger_02.get() != 1) {

        }
        printThree.run();
    }
}
