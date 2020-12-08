package com.gavin.kotlintest.core

class Simple02 {
}

val name : String = "Peter"
var age : Int = 0

fun common() {
    println("我就是方法")
}

fun main() {
    name.let {  }

    var r = common().myRun {
        println("aaaaa")
        true
        '男'
        "AAAA"
    }

    myWith(name) {
        length
    }

    name.mylet { length }

    onRun(true) {
        println("执行了...")
    }

    onRun(true, {
        println("执行了2222")
    })

    val runValue = Runnable { println("我就是Runnable 任务") }

//    onRun(true, runValue:run)

}

// TODO m: T.() -> R
// T.() == 给T一个匿名函数
fun <T,R> T.myRun(m:()-> R) : R = m() // 调用高阶函数

// 普通函数
fun <T,R> myWith(input:T,mm: T.() -> R) :R {
    return input.mm() // this
}

fun <T,R> T.mylet(mm: T.(T) -> R) : R {
    // T == this ()-> R
    return mm(this)
}

// 控制器 如果你是true，我就执行拟，否则不执行

inline fun onRun(isRun : Boolean, mm:() -> Unit) {
    if (isRun) mm()
}