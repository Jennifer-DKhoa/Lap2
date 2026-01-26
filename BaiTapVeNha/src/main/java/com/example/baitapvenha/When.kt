package com.example.baitapvenha

fun main() {
    // --- CACH 1: when kiem tra gia tri cu the (Giong switch-case) ---
    println("--- CACH 1: Value Matching ---")
    var value: Int = 2
    when (value) {
        1 -> println("Hello Obama")
        2 -> println("Hello Putin")
        3 -> println("Hello Kim Jong Un")
        else -> println("Hello Everyone!")
    }

    // --- CACH 2: when la mot bieu thuc (Expression) ---
    // Tra ve gia tri de gan thang vao bien kq
    println("\n--- CACH 2: Return Result ---")
    var x: Int = 8

    // Logic:
    // Neu x thuoc [1..10] thi kq = x + 100
    // Neu x thuoc [20..30] thi kq = x - 1000
    // Con lai thi giu nguyen x
    var kq = when (x) {
        in 1..10 -> x + 100
        in 20..30 -> x - 1000
        else -> x
    }
    println("x = $x -> Ket qua = $kq")

    // --- CACH 3: when thay the if-else (Khong can tham so dau vao) ---
    println("\n--- CACH 3: Replacement for If-Else ---")
    // Cach nay giup code gon hon, do phai go "if... else if..."
    when {
        x % 2 == 0 -> println("X ($x) la so chan")
        x % 2 != 0 -> println("X ($x) la so le")
    }
}