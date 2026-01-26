package com.example.baitapvenha

fun main() {
    println("--- Mo phong chay App Android tren Console ---")

    // 1. Gia lap su kien bam nut
    // (Vi o day khong co nut buttonabc that de bam)
    println(">>> Gia su: Nguoi dung vua bam vao nut 'buttonabc'")

    // Thay vi set text cho textView, ta in ra man hinh
    var noiDungText = "chao tat ca cac ban"
    println("Ket qua tren man hinh hien thi: $noiDungText")

    println("--------------------------------")

    // 2. Logic tinh toan
    var a: Int = 5
    var b: Int = 10
    var c: Int = a + b

    // 3. Thay Log.d bang println
    // Log.d("ketqua", c.toString()) ->
    println("Log [ketqua]: $c")

    // Log.d("soa", a.toString()) ->
    println("Log [soa]: $a")
}