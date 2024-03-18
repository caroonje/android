package com.bitc.app1226

fun main(): Unit {

//    var data1: Int=10
//    데이터 타입 추론 방식을 사용하기 때문에 변수 선언과 동시에 저장되는 데이터의 타입에 따라 변수의 데이터 타입이 결정됨
//    변수의 선언과 동시에 값을 초기화 하는 것이 좋음
    var data1 = 10

//    자바의 if 문과 동일하게 사용하는 것이 가능함
    if (data1 > 0) {
        println("data1 > 0")

    } else {
        println("data1 <= 0")
    }

    if (data1 > 10) {
        println("data1 >10 ")
    } else if (data1 > 0 && data1 <= 10) {
        println("data1 > 0 && data1 <= 10")
    } else {
        println("data1 <=0")
    }

//    조건문을 표현식을 사용하는 것이 가능함 (변수의 값에 바로 if문 사용이 가능)

    var result = if (data1 > 0) {
        println("data1 > 0")
        true
    } else {
        println("data1<=0")
        false
    }
    println("result : $result")


//    자바에서 구현시
    data1 = 10
    result = false

    if (data1 > 0) {
        println("data1 > 0")
        result = true
    } else {
        println("data <= 0")
        result = false
    }
    println("result : $result")


    println("\n-----------when----------\n")

//    자바의 switch문과 비슷
//    ->가 switch문의 case 대신
    var data2 = 10
    when (data2) {
        10 -> println("data2 is 10")
        20 -> println("data2 is 20")
        else -> {
            println("data is not valid data")
        }
    }

//    {}한줄 이상 사용시 붙여주면 됨
    var data3 = "hello"
    when (data3) {
        "hello" -> {
            println("data3 is hello")
        }

        "world" -> println("data3 is world")
        else -> println("data3 is not valid data3")
    }

    var data4: Any = 10
    when (data4) {
        is String -> println("data4 is String") // is 데이터 타입확인 연산자, 지정한 데이터 타입이 맞으면 true 아니면 false 를 출력
        20, 30 -> println("data is 20 or 30") // 데이터 일치 확인 ',' 으로 여러가지 값 동시에 확인 가능
        in 1..10 -> println("data4 is 1..10") //in 시작 .. 종료 : 범위 지정 연산자, 시작부터 종료까지의 데이터에 포함되어 있으면 true, 아니면 false를 출력
        else -> println("data4 is not valid")
    }

    result = data4 is String
    println("result: $result")
    result = data4 in 1..10
    println("result: $result")

//    when 도 표현식으로 사용이 가능함
//    when 사용 시 조건 데이터를 생략 해도 상관 없음(조건데이터 생략시 when 의 코드 블럭 안에서 조건식을 직접 모두 입력해야함)

    var data5 = 10
    var result1 = when {
        data5 <= 0 -> "data5 is <= 0"
        data5 > 100 -> "data5 is >1 00"
        else -> {
            "data5 is valid"
        }
    }
    println("result1 : $result1")

    var data6: Any = 10

    result1 = when (data6) {
        is String -> {
            println("data6 is String")
            "data6 is String"
        }

        20, 30 -> {
            println("data6 is 20 or 30")
            "data6 is 20 or 30"
        }

        in 1..10 -> {
            println("data6 is 1..10")
            "data6 is 1..10"
        }

        else -> {
            println("data6 is not valid")
            "data6 is not valid"

        }
    }
    println("result1 : $result1")


    println("\n-----------반복문 사용----------\n")
    println("\n-----------for문----------\n")
//    in : 지정한 시작 숫자 부터 지정한 종료 숫자까지 1씩 증가하며 반복, <=기호 사용
//    until :  지정한 시작 숫자부터 지정한 종료 숫자까지 1씩 증가하며 반복, 종료 숫자는 포함하지 않음, <기호 사용
//    step : 반복 시 마다 증가시킬 숫자의 크기를 지정
//    downTo : 반복 시 마다 감소시킬 숫자의 크기를 지정

    var sum1: Int = 0
//    코틀린의 for문은 자바의 향상된 for문으로 생각하면됨
    for (i in 1..10) {
        sum1 += i
        println("i : $i, sum1: $sum1")
    }

    println("\n-----------until----------\n")
    for (i in 1 until 10){
        println("i : $i")
    }

    println("\n-----------step----------\n")
    for (i in 0..10 step 2){
        println("i : $i")
    }

    println("\n-----------downTo----------\n")
    for (i in 10 downTo 1){
        println("i : $i")
    }

    println("\n-----------downTo/step----------\n")
    for (i in 10 downTo 0 step 2){
        println("i : $i")
    }

    println("\n-----------indices/withIndex()----------\n")
//    indices : 배열과 같은 컬렉션이 가지고 있는 index를 출력
//    withIndex() : 배열과 같은 컬렉션이 가지고 있는 index와 value를 동시에 출력
    var arr = arrayOf(10,20,30,40,50)
    for (i in arr.indices){
        println("arr[$i] : ${arr[i]}")
    }

    arr = arrayOf(10,20,30,40,50)
    for ((index,value ) in arr.withIndex()){
        println("value : $value, index : $index")
    }
//    배열과 같은 컬렉션만 사용 시 자바의 향상된 for문을 사용하는 것과 동일한 형태로 사용 가능
    for (i in arr){
        println("i : $i")
    }

    println("\n-----------while문----------\n")
//    코틀린의 while문은 자바의 while문과 동일하게 사용함
    var x = 1
    sum1 = 0

    while (x < 11) {
        sum1 += x
        println("x: $x, sum1: $sum1")
        x++
    }

}