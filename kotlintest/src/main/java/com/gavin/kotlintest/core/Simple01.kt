package com.gavin.kotlintest.core

class Simple01 {
}

fun commonOk() {
    println("我就是方法")
}

fun main() {
    commonOk().myRunok { false }
}

// T.() 给万能类型 增加匿名 函数 只不过这个匿名函数 在高阶函数中
// () 就是高阶函数

// 给 ”万能类型“ 类型 增加了扩展函数  一增加   方法.myRunOk
fun <万能类型> 万能类型.myRunok(mm:万能类型.() -> Boolean) {
    mm()
}