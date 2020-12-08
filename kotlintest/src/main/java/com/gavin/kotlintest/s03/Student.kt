package com.gavin.kotlintest.s03


class Student(var id : Int, var name : String, var sex : Char) {
    // component 不能写错
    operator fun component1(): Int = id
    operator fun component2() : String = name
    operator fun component3() : Char = sex
    operator fun component4() : String = "KT Study Ok"
}

fun main() {
    var stu = Student(444,"Peter", 'M')
    val(n1,n2,n3,n4) = stu
    println(n1)
    println(n2)
    println(n3)
    println(n4)
}