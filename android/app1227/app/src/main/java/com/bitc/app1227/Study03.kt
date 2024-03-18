package com.bitc.app1227

//일반 함수 선언
fun function1(num1: Int, num2: Int): Int {
    var result: Int = 0
    result = num1 + num2
    return result
}

//람다함수 (익명함수)로 선언,

val function2 = { num1: Int, num2: Int ->
    var result = 0
    result = num1 + num2
    result
}

//변수에 람다 함수를 저장하는 정석 문법
val function21: (Int, Int) -> Int = { num1: Int, num2: Int ->
    var result = 0
    result = num1 + num2
    result
}

//매개변수가 1개인 람다함수를 변수에 저장할 경우
//변수에 람다함수를 저장하는 정식 문법
val function22: (Int) -> Int = { num1: Int -> num1 * 2 }

//변수 선언과 동시에 람다함수를 저장하면 데이터 타입 추론에 의해서 람다 함수의 매개변수 및 반환 타입을 알 수 있으므로 데이터 타입 설정을 생략
val function23 = { num1: Int -> num1 * 2 }

//람다 함수의 매개 변수가 1개일 경우 데이터 타입을 설정하고 람다 함수의 매개변수와 -> 기호를 생략할 수 있음
//매개변수는 it 키워드로 대체해서 사용
val function24: (Int) -> Int = { it * 2 }


//변수에 일반 함수(익명함수)를 저장
val function3 = fun(num1: Int, num2: Int): Int {
    var result = 0
    result = num1 + num2
    return result
}

//변수에 일반 함수를 저장시 데이터 타입을 지정
val function4: (Int, Int) -> Int = fun(num1: Int, num2: Int): Int {
    var result = 0
    result = num1 + num2
    return result
}

val value1 = 0
val value2: Int = 0

//람다 함수를 쓰는 이유
//1. 소스 코드가 짧아짐
//2. 안드로이드에서 람다 함수를 많이 활용함

//람다 함수 없이 버튼의 클릭 이벤트 발생 소스 코드
//button.setOnClickListener(new OnClickListener(){
//    @Override
//    public void onClick(View view){
//        클릭 시 동작할 소스 코드
//    }
//})

//람다 함수를 사용한 버튼의 클릭 이벤트 발생 소스
//button.setOnclickListener{
//    클릭 시 동작할 소스 코드
//}

//typealias를 통해서 데이터 타입의 이름을 변경
typealias MyInt=Int
typealias MyCalType =(Int,Int)-> Int
fun main() {
    var func :(Int,Int)->Int = { num1: Int, num2: Int -> num1 + num2 }
    var result = func(10,20)
    println("두 수의 합은 $result")

    func = {num1:Int,num2:Int ->
        print("첫번째숫자 : $num1, ")
        print("두번째숫자 : $num2 ")
        var result = num1-num2
        println("두 수의 뺄셈 연산")
        result
    }
    result=func(10,20)
    println(result)

    val data1: Int=100
//    별명을 사용한 데이터 타입으로 변수의 타입 설정
    val data2:MyInt=200

    val sum:MyCalType = {num1:Int,num2:MyInt -> num1+num2}
    val sub:(Int,Int)->Int = fun(num1:Int,num2:Int):Int{
        return num1-num2
    }
    val multi:MyCalType = fun(num1:Int,num2:Int):Int{
        return num1*num2
    }
    val div:(Int,Int)->Int = {num1:Int,num2:Int -> num1/num2}
//    기본 함수 선언
    val func1 = fun (num1:Int,num2:Int):Unit {
    println("num1 : $num1,num2: $num2")
    }
//    함수 저장할 변수명 선언 시  데이터 타입을 지정했을 경우 저장할 함수의 매개변수 타입을 생략해도 됨
    val func2:(Int,Int)->Unit =fun(num1,num2){
        println("num1 : $num1,num2: $num2")
    }
//    람다 함수 사용 시에도 변수에 데이터 타입을 지정했을 경우 저장할 람다 함수의 매개변수 타입을 생략해도됨
    val func3:(Int,Int)->Int = {num1,num2->num1+num2}
    val func4:MyCalType = {num1,num2->num1+num2}

}