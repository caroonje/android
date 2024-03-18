package com.bitc.app1222

fun main(){
    add(10,20)
    println(sub())
    multi(100,12)
    div()
}

//매개변수만 있는 형식
fun add(num1:Int,num2:Int){
    val result = num1+num2
    println(result)

}
//반환값만 있는 형식
fun sub():Int{
    var num1 = 10
    var num2 = 5
    var sub = num1-num2
    return sub

}
//매개변수와 반환값이 있는 형식
fun multi(num1:Int,num2:Int) :Int{
    var result = num1*num2
    println(result)
    return result
}
//매개변수와 반환값이 없는 형식
fun div(){
    var num1 = 9
    var num2 = 3
    var div = num1/num2
    println(div)
}

