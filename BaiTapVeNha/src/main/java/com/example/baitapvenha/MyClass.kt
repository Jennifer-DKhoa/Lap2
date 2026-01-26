package com.example.baitapvenha

import java.util.*

fun main(args: Array<String>) {
    // Tao mang 10 phan tu
    var M: IntArray = IntArray(10)

    var rd = Random()
    for (i in M.indices)
        M[i] = rd.nextInt(100)

    println("Mang sau khi nhap - duyet theo gia tri:")
    for (i in M)
        print("$i\t")
    println()

    println("Mang sau khi nhap - duyet theo vi tri:")
    for (i in M.indices)
        print("${M[i]}\t")
    println()

    // so lon nhat (da sua loi du dau })
    println("MAX=${M.maxOrNull()}")
    // so nho nhat
    println("MIN=${M.minOrNull()}")
    // tong mang
    println("SUM=${M.sum()}")
    // trung binh mang
    println("AVERAGE=${M.average()}")

    // dem so chan
    println("So chan=${M.count { x -> x % 2 == 0 }}")
    // dem so le
    println("So le=${M.count { x -> x % 2 == 1 }}")

    // sap xep tang dan
    M.sort()
    println("Tang dan:")
    for (i in M)
        print("$i\t")
    println()

    // sap xep giam dan
    // (Vi da sap xep tang dan o tren, nen chi can dao nguoc la thanh giam dan)
    M.reverse()
    println("Giam dan:")
    for (i in M)
        print("$i\t")
    println()

    // loc cac so chan trong mang
    var dsChan = M.filter { x -> x % 2 == 0 }
    println("Cac so chan:")
    for (i in dsChan)
        print("$i\t")
    println()

    // loc cac so le trong mang
    var dsLe = M.filter { x -> x % 2 == 1 }
    println("Cac so Le:")
    for (i in dsLe)
        print("$i\t")
    println()

    var k = 50
    // loc cac so > 50 trong mang
    var dsTim = M.filter { x -> x > k }
    println("Cac so > $k:")
    for (i in dsTim)
        print("$i\t")
    println()
}