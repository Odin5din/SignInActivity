package com.example.signinactivity

fun main() {
    println("\n첫 번째 정수를 입력해주세요")
    var input1 = readLine()?.toInt()
    println("\n두 번째 정수를 입력해주세요")
    var input2 = readLine()?.toInt()
    println("\n세 번째 정수를 입력해주세요")
    var input3 = readLine()?.toInt()
    println("\n네 번째 정수를 입력해주세요")
    var input4 = readLine()?.toInt()
    println("\n마지막 정수를 입력해주세요")
    var input5 = readLine()?.toInt()

    var listNum = arrayOf(input1, input2, input3, input4, input5)
    println("정렬 전 값은 ${listNum.contentToString()} 입니다.")

    val selectionSort = SelectionSort(listNum)
    val sortedListNum = selectionSort.sort()

    println("\n정렬 후 값은 ${sortedListNum.contentToString()}")


}

private class SelectionSort(var listNum: Array<Int?>) {
    fun sort(): Array<Int?> {
        var min: Int
        for (i in listNum.indices) {
            min = i
            for (j in i + 1 until listNum.size) {
                if (listNum[j]!! < listNum[min]!!) {
                    min = j
                }
            }
            changePosition(listNum, min, i)
        }

        return listNum
    }

    private fun changePosition(listNum: Array<Int?>, min: Int, i: Int) {
        var tempt: Int
        tempt = listNum[min]!!
        listNum[min] = listNum[i]
        listNum[i] = tempt

    }

}

