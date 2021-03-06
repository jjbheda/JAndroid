package com.gavin.kotlintest.s04

import com.sun.org.apache.bcel.internal.generic.IFLE
import java.io.File

fun main() {
    val stu = Student()
    stu.add(100, 200)

    val file = File("///")
    file.readText()
    file.show()
}

// 扩展函数
fun Student.add(n1: Int, n2 : Int) {
    println("结果：${n1+ n2}")
}

fun Student.show() {
    println("Student show")
}

// 给java File 增加扩展函数
fun File.show() {
    println("给java FIle 增加 扩展函数")
}