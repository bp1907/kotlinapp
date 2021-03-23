package com.wanma.kotlinapp.KotlinLearning

/**
 * author: wanma
 * Date: 2020/6/30
 * Description
 */
class Test {
    val num1: String? = null

    class Zhu {
        val nums : String? = null
    }

    inner class Wang {
        val num: String? = null
    }
}

fun main() {

    Test.Zhu().nums
    Test().Wang().num
    val result = num1AndNum2(10, 20) {n1, n2 -> n1 + n2}
    println("num1AndNum2: ${num1AndNum2(80, 100, ::plus)}")
    println("num1AndNum2: ${num1AndNum2(80, 100, ::minus)}")

    var name = "123"
    var age = 11

    name.myLet {
       println(length)
    }
    age.myLet {
        toDouble()
    }
    age.let {
    }

    sun {
        println("---$it----")
        ""
    }
}

fun sun(mm: (Int) -> String) {
}

fun <T,R> T.myLet(mm: T.() -> R) : R{
    return mm(this)
}

typealias Operator = (Int, Int) -> Int

inline fun num1AndNum2(num1: Int, num2: Int, operator: Operator) : Int {
//    test(num1, operator)
    return operator(num1, num2)
}

//fun test(num1: Int, op: Operator) : Int {
//    return op(num1, num1)
//}

fun plus(num1: Int, num2: Int) : Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int) : Int {
    return num1 - num2
}