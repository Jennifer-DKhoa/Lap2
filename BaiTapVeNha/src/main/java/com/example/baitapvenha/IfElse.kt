package com.example.baitapvenha

fun main() {
    // --- Cach 1: If-else truyen thong ---
    var a: Int = 10
    var b: Int = 15
    var max1: Int
    if (a > b)
        max1 = a
    else
        max1 = b
    println("So lon nhat = $max1")

    // --- Cach 2: If la mot bieu thuc (Expression) ---
    // (Kotlin cho phep gan ket qua cua lenh if thang vao bien)
    var max = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }
    println("max = $max")

    // --- Vi du 2: If long nhau (Nested If) ---
    val guests = 30
    if (guests == 0) {
        println("No guests")
    } else if (guests < 20) {
        println("Small group of people")
    } else {
        println("Large group of people!")
    }

    // --- Vi du 3: If don ---
    var tb: Double = 8.0
    if (tb >= 5) {
        println("Dau (Vi du 3)")
    }

    // --- Vi du 4: Nhap lieu va xep loai ---
    var dtb: Double = 0.0
    println("----------------------------")
    print("Moi ban nhap diem trung binh: ") // Dung print de nhap cung dong

    // Doc du lieu tu ban phim
    var s: String? = readLine()

    // Kiem tra xem co nhap gi khong
    if (s != null && s != "") {
        // Chuyen doi chuoi sang so thuc
        // (Luu y: Neu nhap chu thay vi so se bi loi, nhung tam thoi cu de don gian)
        try {
            dtb = s.toDouble()

            // Logic kiem tra diem
            if (dtb >= 0 && dtb <= 10) {
                if (dtb >= 5) {
                    println("Ket qua: Dau")
                } else {
                    println("Ket qua: Rot")
                }
            } else {
                println("Loi: Ban phai nhap diem trong khoang [0...10]")
            }
        } catch (e: Exception) {
            println("Loi: Ban nhap khong phai la so!")
        }
    } else {
        println("Loi: Ban chua nhap gi ca (hoac nhap sai)")
    }
}