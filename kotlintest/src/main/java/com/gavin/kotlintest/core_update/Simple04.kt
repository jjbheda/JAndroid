package com.gavin.kotlintest.core_update

import com.gavin.kotlintest.core.mylet

val name = "A"
val age = 999
val sex = 'M'

fun main() {
    var length = name.myApply {  }
            .myApply {  }
            .myApply {  }
            .length

    val r = name.myAlso {  }
            .myAlso { it.length }.toString()

    name.mylet {
        // 你传入了一个T==this  参数1==it
        it.length
    }

    name.myLet2 {
        length
        length
        length
    }
}

fun <T> T.myApply(mm : () -> Unit) : T {
    // T == this
    mm()
    return this
}

fun <T> T.myAlso(mm : (T) -> Unit) : T {
    // T == this
    // it == T == this == name
    mm(this)
    return this
}

// (it.lenght) ----- it == T == this == name
fun <T, R> T.myLet(mm : (T) -> R) : R = mm(this)

// 不想要it  给 T 增加”匿名的扩展函数“  ==  把this 带过去 ，并且，此函数 形参是T

fun <T, R> T.myLet2(mm : T.() -> R) : R {
    return mm()
}

