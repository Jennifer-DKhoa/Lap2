package com.example.baitapvenha

fun main() {
    println("Xin chao tat ca")
    println("Hom nay troi nhe len cao")
    println("Toi buon khong hieu vi sao toi buon")
    println("Troi hom nay dep qua")

    var a: Long = 100L
    // Dung String Template ($a) thay vi phep cong (+)
    println("So a la: $a")

    // --- HAM CUC BO (Local Function) ---
    // Day la ham duoc dinh nghia ben trong ham main
    fun printHello() {
        println(">>> Day la ham hien thi hello")
    }

    // Goi ham vua tao
    printHello()
}