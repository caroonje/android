package com.bitc.app1227

//일반 함수 선언
fun sum1(no1: Int, no2: Int): Int {

    return no1 + no2
}

//람다 함수 선언 변수에 저장
//변수명(매개변수값) 형태로 함수를 호출 할 수 있음
val sum2 = { no1: Int, no2: Int -> no1 + no2 }

//일반적인 매개변수가 있는 람다 함수
val ptr1 = { str: String -> println("출력할 문장 : $str") }

//매개변수가 없는 람다 함수 1
val ptr2 = { -> println("출력할 문장 : 안녕하세요") }

//매개변수가 없는 람다 함수 2, 매개변수가 없으니 ->기호도 생략
val ptr3 = { println("출력할 문장 : 안녕!~~~") }
//매개변수가 1개인 람다 함수 선언
val ptr4 = { no: Int -> println(no) }
//매개 변수가 1개인 람다함수 2번째 선언 방식, 데이터 타입이 무엇인지 확인 할 수 있을 때 사용가능
//변수 선언 시 '변수명: 데이터 타입'의 데이터 타입 부분에 (Int)-> Unit 형태를 사용하여 해당 변수의 타입이 함수 타입임을 알려줌
//it : 매개변수가 1개인 람다함수 사용시 매개변수의 데이터를 가져오는 키워드
val ptr5: (Int) -> Unit = { println(it) }
val ptr6 = {no1:Int,no2:Int -> no1+no2}
val ptr7 ={no1:Int,no2:Int->
    println("람다 함수 안에서 활용")
    println("아래의 내용은 반환됨")
    no1+no2
}
fun main() {

    var result = sum1(10, 20)

    println("두 수의 합 : $result")

    result = sum2(10, 20)
    println("두 수의 합 : $result")
//  람다 함수를 선언과 동시에 호출하여 사용할 수 있음
    println({ no1: Int, no2: Int -> no1 + no2 }(10, 20))

    println("\n-------매개 변수가 없는 람다함수--------\n")
    ptr1("helloworld!")
    ptr2()
    ptr3()

    println("\n-------매개 변수가 1개인 람다함수--------\n")
    ptr4(100)
    ptr5(100)

    println("\n-------반환값을 사용한 람다함수--------\n")
    result = ptr6(10,20)
    println("한줄 실행형 람다함수 사용 : $result")
    result = ptr7(10,20)
    println("여러줄 실행형 람다함수 사용 : $result")
}