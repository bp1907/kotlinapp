package com.wanma.kotlinapp.KotlinLearning

import kotlin.concurrent.thread

/**
 * author: wanma
 * Date: 2020/5/20
 * Description
 */
class KotlinGrammar {
}

val name = "wangzhen"
val age = 0
val a : Int = 10

fun test(num1 : Int, num2 : Int) {
    
}

fun commonOk() {
    println("我就是方法")
}

fun <T> T.myRun(mm: () -> Boolean) : Boolean{
    return mm()//执行高阶
}

fun main() {

    var a = 1
    val s1 = "a is $a"
    a = 2
    println(s1)

    var c : Int

    val list = listOf("Apple", "Banana", "Orange", "pear", "Grape", "Watermelon")

    val newList = list.map { it.toUpperCase() }
    val newList2 = list.map { it.first() }

    for (fruit in newList2) {
        println(fruit)
    }

    Thread { print("Thread is running") }.start()

    commonOk().myRun {
        true
    }

    commonOk().run {
        this.toString()
    }
//    name.myRun {
//        println("myRun")
//    }
//
//    login("wangzhen", "123456") {a, b ->
//        println("login: $a, $b")
//        "yes"
//    }


    //TODO 定义没问题，调用不行(没有具体的实现)
  /*  var m01: () -> Unit
//    m01() //不能调用，没有具体的实现
    var m02: (Int,Int) -> Int
//    m02(9,9)
    var m03: (String, Double) -> Any?
//    m03("user", 11.3)

    //TODO 定义没问题，也可以调用，因为有了实现
    // : (形参类型)
    // = {具体详情}
    var m04: (Int, Int) -> Int = {num1, num2 -> num1 + num2}
    println("m04: ${m04(9, 9)}")
    var m05 = {num1: Int, num2: Int -> num1 + num2.toDouble()}
    println("m05: ${m05(8, 8)}")
    var m06: (String, String) -> Unit = {a,b -> println("m06: a = $a, b = $b")}
    m06("aaa", "bbb")
    var m07: (String, String) -> Unit = {a,b -> println("m07: 不使用参数") }
    m07("q","w")
    var m08: (String) -> String = {str -> str}
    println("m08: ${m08("我就是我")}")
    var m09: (Int) -> Unit = {
        when(it) {
            1 -> println("我是一")
            in 1..50 -> println("我在1到50之间")
            else -> println("我是其他数字")
        }
    }
    m09(49)
    var m10 = { println("我只用打字")}
    m10()
    //覆盖操作
    var m11 = {num: Int -> println("m14: 我的值是$num")}
    m11 = { println("覆盖m11 我的值是$it")}
    m11(11)
    //打印还可以返回值
    var m12 = {num: Int -> println("我想打印: $num")
    num + 100}
    println("m12: ${m12(99)}")
    var m13 = {num: Int -> println("我想打印: $num")
        num + 100
        println("我还想打印: $num")}
    println("m13: ${m13(1000)}")


    // TODO 高阶登录需求
    login("wangzhen", "123456")

    // TODO 再次模拟登录流程
    loginEngine("wangzhen", "123456") {
        if(it) println("又登录成功啦") else println("又登录失败啦")
    }*/

}

//在内部完成登录功能
fun loginEngine(username: String, password: String, responseResult: (Boolean) -> Unit) {
    if(username == "wangzhen" && password == "123456") {
        //可以做很多业务逻辑
        responseResult(true)
    }else {
        //....
        responseResult(false)
    }
}

fun login(username: String, password: String) {
    //使用高阶{}
    loginService(username, password) { user, pwd ->
        if(user == "wangzhen" && pwd == "123456") {
            println("登录成功")
        }else {
            println("登录失败")
        }
    }
}
fun loginService(username: String, password: String, loginInter: (String, String) -> Unit) {
    loginInter(username,password)
}

//fun login(username: String, password: String, loginInter: (user: String, pwd: String) -> String) {
//    if(username == "wangzhen" && password == "123456") {
//        println("登陆成功")
//    }else {
//        println("登录失败")
//    }
//    val a = loginInter(username, password)
//    println(a)
//}
//
//fun <T,R> T.myRun(mm: () -> R) : R {
//    return mm()
//}

