package com.example.signinactivity

fun main() {
    println("금액을 넣어주세요!")

    var input1 = readLine()
    var cash = input1?.toInt()



    if (cash!! >= 500) {
        println("음료수가 나왔습니다.")
    } else {
        println("금액이 부족합니다. 추가금액을 넣어주세요!")
        var input2 = readLine()
        var morecash = cash!! + input2!!.toInt()
        if (morecash >= 500) {
            println("음료수가 나왔습니다.")
        } else
            println("금액이 부족하여 반환되었습니다.")
    }
}
