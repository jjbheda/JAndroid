package com.gavin.kotlintest.core

class Simple {
}



fun main() {
//    var method01 : () -> Unit

//    method01()  不能调用，没有具体的实现

//    var method02 : (Int, Int) -> Int
//    method02(9,9)   提示必须初始化

//    var method03 : (String ,Double) -> Any?
//    method03("Derry", 54444.4)   提示必须初始化

//    var method04 : (Int, Double, Long, String ?) -> Boolean
//    method04(1,54,1212,null)  提示必须初始化

//    var method05 : (Int, Int) -> Int
//    method05(9,9)   提示必须初始化

    // : (形参类型)
    // = (具体详情)

    // 定义没有问题，调用OK,因为有具体实现了

    var m06 : (Int, Int) -> Int = {num1,num2 -> num1 + num2}
    println("m06:${m06(9,9)}")

    var m07 = {num1: Int, num2: Int -> num1.toDouble() + num2.toDouble()}
    println("m07:${m07(1000,1000)}")

    var m08 : (String, String) -> Unit = {aString ,bString -> println("a:$aString,  b:$bString")}
    m08("李元霸", "王五")

    var m09 : (String) -> String = {str -> str}
    println("m09:${m09("降龙十八掌")}")


    var m10 : (Int) -> Unit = {
        when(it) {
            1 -> println("你是1")
            in 20..30 -> println("你是20到30")
            else -> println("其他的数字")
        }
    }

    m10(29)

    var m11 : (Int, Int, Int) -> Unit = {n1, n2, n3 ->
        println("n1:$n1, n2:$n2, n3:$n3")
    }

    m11(1,2,3)


    var m12 = {println("我就是M12 函数，我就是我")}
    m12()

    var m13 = {sex : Char ->
        if (sex == 'M') "代表是男的"
        else "代表是女的"
    }

    println("m13:${m13('M')}")

    // 覆盖操作
    var m14 = {number : Int -> println("我就是m14  我的值: $number")}

    m14(99)

    // 需求：我想打印， 并且，我还想返回值，就是 我什么都想要
    var m15 = {
        number : Int ->
        println("我想打印： $number")
        number + 10000

    }

    println("m15:${m15(88)}")

    loginEngine("Derry", "123456")
}


// 对外暴露

fun loginEngine(userName : String, userPwd : String) : Unit {

    // 使用高阶
    loginService(userName, userPwd) { name, pwd ->
        if (name == "Derry" && pwd == "123456") {
            println("恭喜:${name}登录成功")
        } else {
            println("登录失败，请检查 用户名 或 密码....!!")
        }

    }

}

// 标砖 String String ->Unit
typealias RequestLogin = (String ,String) -> Unit

private fun loginService(userName: String, userPwd: String, requestLogin : RequestLogin) : Unit {
    requestLogin(userName, userPwd)
}