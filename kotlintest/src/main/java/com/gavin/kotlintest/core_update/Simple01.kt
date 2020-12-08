package com.gavin.kotlintest.core_update

fun main() {
    show1("Derry") {
        println("输出: $it")
    }

    show1("李元霸", mm = {
        print("初始2: $it")
    })

    show1("雄霸",{
        println("输出3: $it")
    })

    show1 {
        println("输出4：$it")
    }

    sun1{
        println("输出5: $it")
    }

    sun1({
        println("输出6:$it")
    })

    // 一个参数的话，就是默认的it
    sun1({

    })

    sun2({ n1, b2 ->

    })

}


fun show1(name:String = "李连杰", mm:(String) -> Unit) {
    mm(name)
}

fun sun1(mm:(Int) -> Unit) {
    mm(9)
}

fun sun2(mm : (Int ,Boolean) -> Unit) {
    mm(9, true)
}

