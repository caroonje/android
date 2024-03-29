package com.bitc.app1226
//1. 코틀린의 클래스는 기본적으로 상속 불가능
//2. 코틀린에서 클래스를 상속하려면 상속해줄 부모 클래스에 open키워드를 사용해야함
//3. 상속 시 자식 클래스명 : 부모 클래스() 형태로 사용
//4. 자식 클래스의 생성자에서 부모 클래스의 생성자를 호출 해야함

//super() : 자바와 동일하게 부모 생성자를 호출하는 함수


//생성자가 매개변수가 없는 부모 클래스 Parent1 선언
open class Parent1 {
    val parentField1 = 100
    fun parentMethod1() {
        println("부모 클래스의 멤버 메소드")
    }
}

//부모 클래스 Parent1을 상속받는 자식 클래스 child1 선언
//자식 클래스 Child1  도 생성자에 매개변수와 소스코드가 없음
//상속 받는 부모 클래스의 기본 생성자를 입력
class Child1 : Parent1() {
    var childField1 = 1000

    fun childMethod1() {
        println("자식 클래스의 멤버 메소드")
    }
}

//부모 클래스 Parent1을 상속받는 자식 클래스 child11 선언
//자식 클래스 Child11은 매개변수가 있고, 소스코드가 없는 생성자 보유
//상속받은 부모 클래스의 기본 생성자를 입력하여 상속
class Child11(val childField2: Int) : Parent1() {
    var childField1 = 1000

    fun childMethod() {
        println("자식 클래스 Child11 의 멤버 메소드")
    }
}

//생성자에 매개변수가 있고 , 소스코드가 없는 부모 클래스
open class Parent2(var parentField2: String) {
    var parentField1 = 100

    fun parentMethod() {
        println("부모 클래스 Parent2의 메소드")
    }
}

//부모 클래스 Parent2 를 상속받은 자식 클래스 Child2
//자식 클래스 Child21의 생성자는 매개변수와 소스코드가 없음
//상속받는 부모 클래스의 매개변수가 있는 생성자를 입력
class Child21 : Parent2("홍길동") {
    var childField1 = 1000

    fun childMethod() {
        println("자식 클래스 Child21의 메소드")
    }
}

//부모 클래스 Parent2 를 상속받은 자식 클래스 Child22
//자식 클래스 Child22의 생성자는 매개변수를 가지고 있음
//상속받는 부모 클래스의 매개변수가 있는 생성자를 입력
//자식 클래스의 생성자 매개변수를 부모 클래스의 생성자를 호출하는데 사용함
class Child22(name: String) : Parent2(name) {
    var childField1 = 1000

    fun childMethod() {
        println("자식 클래스 Child22의 메소드")
    }
}

//부모 클래스 Parent2를 상속받은 자식 클래스 Child23
//자식 클래스 Child22와 동일한 형태이나 보조 생성자(constructor)를 사용한 형식
//보조 생성자에서 부모 클래스의 생성자를 호출하는 함수 super() 를 사용하여 부모 생성자를 호출함
class Child23 : Parent2 {
    var childField1 = 1000

    constructor(name: String) : super(name) {
    }

    fun childMethod() {
        println("자식 클래스 Child23의 메소드")
    }
}

//부모 클래스 선언, 상속 가능하도록 open 키워드 사용
open class Parent3 {
    open var someData = 10
    open fun someFun() {
        println("부모 클래스의 메소드 실행 : $someData")
    }
}

//부모 클래스 Parent3를 상속받는 자식 클래스 Child3
class Child3 : Parent3() {
    //    부모클래스에서 상속받은 멤버와 동일한 이름의 멤버 변수 및 메소드를 선언하여 오류가 발생함
//    오류 없이 사용하고자 할 경우 오버라이딩이 필요함
//    코틀린에서는  자바와는 달리 override키워드가 기본 제공됨
//    오버라이딩 시 부모 클래스의 멤버에 open 키워드가 있어야 함
    override var someData = 200
    override fun someFun() {
        println("자식 클래스의 메소드 실행 : $someData")
    }
}

//접근제한자 : 코틀린에서는 public,private,protected,internal 4가지는 제공함
//기존 자바와 동일하며 , internal 은 자바의 default 와 동일함
//protected 는 클래스에서는 자바와 동일하지만 코틀린에서는 파일의 최상위 멤버로 변수와 함수가 존재하기 때문에 변수와 함수에는 protected를 사용할 수 없음
//코틀린의 기본 접근 제한자는 public임, 접근제한자 생략 시 public으로 동작함
open class Parent4 {
    //    접근제한자 생략 , 기본 접근제한자인 public 사용
    var publicData = 10

    //    protected를 사용하여 자식 클래스에서는 사용 가능
    protected var protectedData = 20

    //    현재 클래스 내부에서만 사용 가능
    private var privateData = 30
}

class Child4 : Parent4() {
    fun child4Fun() {
//        접근제한자가 public 이므로 어디서나 사용 가능
        publicData++
//        접근제한자가 protected이므로 Parent4 클래스를 상속받은 Child4 내부에서 사용가능
        protectedData++
//       접근 제한자가 private이므로 자식 클래스인 Child4에서 사용할수 없음
//        privateData++
    }
}

class NonDataClass(val name: String, val email: String, val age: Int) {

}

data class DataClass(val name: String, val email: String, val age: Int){

}

fun main() {
    println("------------클래스 상속----------")

//    자식 클래스 Child1 타입의 객체 child1 생성

    val child1 = Child1()
    println(child1.parentField1)
    println(child1.childField1)
    child1.parentMethod1()
    child1.childMethod1()

    val child11 = Child11(1000)
    println(child11.parentField1)
    println(child11.childField1)
    println(child11.childField2)

    val child21 = Child21()
    println(child21.parentField1)
    println(child21.parentField2)
    println(child21.childField1)

    val child22 = Child22("홍길동")
    val child23 = Child23("홍길동")


    println("\n--------오버라이딩--------\n")

    val child3 = Child3()
    println("자식 클래스 Child3의 객체 child3의 someData : ${child3.someData}")
    child3.someFun()

    println("\n--------접근제한자--------\n")
    val child4 = Child4()
    child4.child4Fun()

//    접근 제한자가 public이므로 어디서든 사용가능
    child4.publicData++
//    접근 제한자가 protected 이므로 Parent4 클래스를 상속받은 Child4내부에서는 사용가능하나 외부에서는 사용 불가
//    child4.protectedData++
//    접근 제한자가 private 이므로 부모클래스인 Parent4 내부에서만 사용 가능
//    child4.privateData++

    println("\n--------데이터 클래스--------\n")

//     데이터 저장 경로 비교
    val nd1 = NonDataClass("아이유", "iu@bitc.ac.kr", 30)
    val nd2 = NonDataClass("아이유", "iu@bitc.ac.kr", 30)

    println("nd1  : ${nd1.name},nd1  : ${nd1.email},nd1  : ${nd1.age}")
    println("nd2  : ${nd2.name},nd1  : ${nd2.email},nd2  : ${nd2.age}")

//    일반 클래스로 객체를 생성 시 동일한 데이터가 들어가 있다고 하여도 메모리 상에 생성되는 주소가 다르기 때문에 서로 다른 데이터로 인식
    var result: Boolean
    result = nd1 == nd2
    println("nd1과 nd2의 비교 :  $result")


//    data 타입의 데이터 비교
    val dc1 = DataClass("아이유", "iu@bitc.ac.kr", 30)
    val dc2 = DataClass("아이유", "iu@bitc.ac.kr", 30)

    println("dc1  : ${dc1.name},dc1  : ${dc1.email},dc1  : ${dc1.age}")
    println("dc2  : ${dc2.name},dc2  : ${dc2.email},dc2  : ${dc2.age}")

//    데이터 클래스로 만들어진 객체를 서로 비교 시 객체의 주소를 비교하는 것이 아니라 서로가 가지고 있는 데이터를 비교하여 같은지 아닌지 확인함
//    equals() : 서로의 데이터가 같은지 아닌지를 확인하는 메소드
    result = dc1 == dc2
    println("dc1과 dc2의 비교 :  $result")

    println()
    result = nd1.equals(nd2)
    println("nd1과 nd2의 비교 :  $result")

    result = dc1.equals(dc2)
    println("dc1과 dc2의 비교 :  $result")

//    toString() : 객체가 가지고 있는 데이터를 출력하는 메소드
    println("일반 클래스의 객체 출력 시 : ${nd1.toString()}")
    println("데이터 클래스의 객체 출력 시 : ${dc1.toString()}")
}
