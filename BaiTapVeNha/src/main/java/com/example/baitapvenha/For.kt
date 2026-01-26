package com.example.baitapvenha

fun main() {
    var sum: Int = 0
    val n: Int = 5

    // Luu y: "until" la chay den gan n (tu 1 den 4), khong lay so 5
    // Neu muon lay ca so 5 thi dung "1..n"
    for (i in 1 until n) {
        sum += i
    }
    println("Tong = $sum")

    // --- Hien thi danh sach mang ---
    var dsSanPham = arrayOf("kotlin", "java", "c#", "python", "R")

    // Cach 1: Duyet truc tiep tung phan tu
    println("--- Cach 1: Duyet item ---")
    for (item in dsSanPham)
        println(item)

    // Cach 2: Duyet theo chi so (index)
    println("--- Cach 2: Duyet theo index ---")
    for (i in dsSanPham.indices)
        println("San pham thu $i co ten: ${dsSanPham[i]}")

    println("-------------")

    // Cach 3: Duyet ca chi so va gia tri (Ngau nhat)
    println("--- Cach 3: Dung withIndex ---")
    for ((index, value) in dsSanPham.withIndex()) {
        println("San pham thu $index co ten: $value")
    }
}