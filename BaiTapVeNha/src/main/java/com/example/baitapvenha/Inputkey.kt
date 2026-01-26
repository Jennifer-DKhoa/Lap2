package com.example.baitapvenha

fun main() {
    var a: Double = 0.0
    var b: Double = 0.0

    // Nhap a
    print("Nhap a: ")
    var s = readLine()
    if (s != null && s != "") {
        a = s.toDouble()
    }

    // Nhap b
    print("Nhap b: ")
    s = readLine() // Tai su dung bien s
    if (s != null && s != "") {
        b = s.toDouble()
    }

    // Giai phuong trinh bac nhat: ax + b = 0
    if (a == 0.0 && b == 0.0) {
        println("Ket qua: Phuong trinh vo so nghiem")
    } else if (a == 0.0 && b != 0.0) {
        println("Ket qua: Phuong trinh vo nghiem")
    } else {
        var x = -b / a
        println("Ket qua: Nghiem x = $x")
    }
}