package com.gavin.kotlintest.s05

fun main() {
    show(true, {
        'M'
    })
}


fun loginMethod(b : Boolean) : Unit {

}


// loginMethod 方法名
// (Boolean)方法的那个括号
// -> 方法体 干活
// Unit == void

fun show(isLogin : Boolean, loginMethod:(Boolean)->Char) {
    if (isLogin) {
        println("登录成功")
        var r = loginMethod(true)
    } else {
        println("登录失败")
        loginMethod(false)
    }
}