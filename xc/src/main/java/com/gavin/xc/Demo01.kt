package com.gavin.xc

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    // 非阻塞 类似于 守护线程
    GlobalScope.launch {
        delay(1000)
        println("111111")
    }

    println("A")

    // main 线程 睡眠2s
    Thread.sleep(200)
    println("B")

    // main 结束
}