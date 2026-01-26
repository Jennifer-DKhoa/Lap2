package com.example.baitapvenha

fun main() {
    // --- 1. MutableList (Danh sach co the thay doi) ---
    var ds1: MutableList<Int> = mutableListOf(1, 2, 3, 4)

    println("DS1 ban dau: $ds1")

    // Xoa sach phan tu
    ds1.clear()
    println("DS1 sau khi clear: $ds1") // Ket qua se la []

    println("-------------------------")

    // --- 2. List (Danh sach chi doc - Immutable) ---
    var ds2: List<Int> = listOf(1, 2, 3, 4)
    println("DS2 (Chi doc): $ds2")

    /* Luu y quan trong:
       ds2.clear() -> Bi loi ngay lap tuc!
       Vi 'List' thuong trong Kotlin la bat bien (Immutable),
       no khong co cac ham sua doi nhu: add, remove, clear, set...
    */

    println("-------------------------")

    // --- 3. Them phan tu vao MutableList ---
    var ds3: MutableList<Int> = mutableListOf(5, 6, 1, 0, 4)

    // Them phan tu vao cuoi danh sach
    ds3.add(4)
    ds3.add(5)

    println("DS3 sau khi them so 4 va 5:")
    println(ds3)
}