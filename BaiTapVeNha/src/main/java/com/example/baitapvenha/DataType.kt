package com.example.baitapvenha

fun main() {
    var x: Long = 100L
    var y: Double = 113.5
    var f: Float = 113.5f
    var i: Int = 113
    var s: Short = 8
    var b: Byte = 1
    var c: Char = 'c'
    var kq: Boolean = true
    var ten: String = "vku.udn.vn"

    // Da chuyen thanh khong dau
    var address: String = """
    so 90 ngu 
    hanh son
    """
    println(address)

    // Mang so nguyen
    var arrX: IntArray = intArrayOf(1, 2, 3, 5)
    println("Phan tu thu 2 cua mang X: ${arrX[1]}")

    // Mang so thuc
    var arrY: DoubleArray = doubleArrayOf(1.5, 2.6, 9.0, 10.3)
    println("Phan tu thu 4 cua mang Y: ${arrY[3]}")

    // Mang ky tu
    var arrC: CharArray = charArrayOf('a', 'b', 'c')
    println("Phan tu dau tien cua mang C: ${arrC[0]}")

    val PI: Double = 3.14
    // PI=3.15 // khong duoc phep vi PI la readonly (val)

    val numberOfDogs = 3
    val numberOfCats: Int = 2

    // String template (giu nguyen Tieng Anh vi khong co dau)
    val stringnumber = "I have $numberOfDogs dogs" + " and $numberOfCats cats"
    println(stringnumber)
}
