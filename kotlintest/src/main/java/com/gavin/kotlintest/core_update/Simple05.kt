package com.gavin.kotlintest.core_update

import kotlin.concurrent.thread

fun main() {
    ktrun() {
        doCounts(100) {
            println("执行了一次  下标是:$it")
        }
    }
    thread {  }
}

// 自定义轮询器

// 自定义轮询 传入9 我就给你 轮询9次

fun doCounts(counts: Int, mm: (Int) -> Unit) {
    for (index in 0 until counts) {
        mm(index)
    }
}

// 自定义线程封装
fun ktrun(
        start: Boolean = true,
        name: String ?= null,
        // ...
        myRunAction:() -> Unit) : Thread {
    val thread = object : Thread() {
        override fun run() {
            super.run()
            myRunAction()
        }
    }

    name ?: "PeterThread"

    if (start)
        thread.start()

    return thread
}