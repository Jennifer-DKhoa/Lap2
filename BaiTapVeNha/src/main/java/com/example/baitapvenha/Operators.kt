package com.example.baitapvenha

fun main() {
    // --- 1. TOAN TU GAN ---
    println("--- TOAN TU GAN ---")
    var a: Int = 5

    a += 2 // a = 5 + 2 = 7
    println("a += 2 -> a = $a")

    a -= 2 // a = 7 - 2 = 5
    println("a -= 2 -> a = $a")

    a *= 2 // a = 5 * 2 = 10
    println("a *= 2 -> a = $a")

    a /= 2 // a = 10 / 2 = 5
    println("a /= 2 -> a = $a")

    a = 7
    a %= 3 // a = 7 chia 3 du 1
    println("a %= 3 -> a = $a") // Lúc này a = 1

    // --- 2. TOAN TU LOGIC ---
    println("\n--- TOAN TU LOGIC ---")
    var x: Boolean = true
    var y: Boolean = false
    var z: Boolean = false

    println("x = $x, y = $y, z = $z")

    // AND (&&)
    println("x && y = ${x && y}")
    println("x.and(y) = ${x.and(y)}")

    // OR (||)
    println("x || y = ${x || y}")
    println("x.or(y) = ${x.or(y)}")
    println("x || z = ${x || z}")

    // Ket hop
    println("x && y && z = ${x && y && z}")
    println("x || y || z = ${x || y || z}")

    // --- 3. TOAN TU SO HOC ---
    println("\n--- TOAN TU SO HOC ---")
    // Lưu ý: Lúc này a đang là 1 (do phep tinh o phan 1)
    var b: Int = 8

    // Tui dung String Template ($) cho gon code nhe
    println("Phep cong (cach 1): $a + $b = ${a + b}")
    println("Phep cong (cach 2): $a + $b = ${a.plus(b)}")

    println("Phep tru (cach 1): $a - $b = ${a - b}")
    println("Phep tru (cach 2): $a - $b = ${a.minus(b)}")

    println("Phep nhan (cach 1): $a * $b = ${a * b}")
    println("Phep nhan (cach 2): $a * $b = ${a.times(b)}")

    println("Phep chia (cach 1): $a / $b = ${a / b}") // Chia lay nguyen (1/8 = 0)
    println("Phep chia (cach 2): $a / $b = ${a.div(b)}")

    println("Chia lay du (cach 1): $a % $b = ${a % b}")
    println("Chia lay du (cach 2): $a % $b = ${a.rem(b)}")

    // --- 4. TOAN TU SO SANH ---
    println("\n--- TOAN TU SO SANH ---")
    println("a == b : ${a == b}")
    println("a.equals(b) : ${a.equals(b)}")
    println("!a.equals(b) : ${!a.equals(b)}") // Phu dinh

    // compareTo: Tra ve 0 neu bang, so am neu nho hon, so duong neu lon hon
    println("3.compareTo(3) = ${3.compareTo(3)}") // Bang nhau -> 0
    println("3.compareTo(5) = ${3.compareTo(5)}") // 3 < 5 -> -1
    println("5.compareTo(3) = ${5.compareTo(3)}") // 5 > 3 -> 1

    // --- 5. TOAN TU TANG GIAM (HACK NAO) ---
    println("\n--- TOAN TU TANG GIAM ---")

    // Reset lai gia tri de tinh cho de
    a = 1
    b = 8
    var c: Int = 2

    a-- // a dang 1 giam xuong 0
    b++ // b dang 8 tang len 9

    // Cong thuc: var xx = a++ + ++b - --c + 7
    // Phan tich tung buoc:
    // 1. a++ (Post-fix): Lay gia tri hien tai cua a (la 0) de tinh, sau do a moi tang len 1. -> Dung so 0.
    // 2. ++b (Pre-fix): Tang b len 1 truoc (9 len 10), sau do lay gia tri. -> Dung so 10.
    // 3. --c (Pre-fix): Giam c xuong 1 truoc (2 xuong 1), sau do lay gia tri. -> Dung so 1.
    // -> Phep tinh thuc te la: 0 + 10 - 1 + 7 = 16

    var xx = a++ + ++b - --c + 7

    println("Ket qua a hien tai = $a") // a tang len 1 o buoc Post-fix
    println("Ket qua b hien tai = $b") // b = 10
    println("Ket qua c hien tai = $c") // c = 1
    println("Ket qua xx = $xx")        // xx = 16
}