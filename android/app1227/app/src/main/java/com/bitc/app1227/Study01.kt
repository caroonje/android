package com.bitc.app1227

//object 키워드를 사용하여 선언과 동시에 객체를 생성하는 오브젝트 클래스 생성
//자바의 추상 클래스와 비슷
//object 키워드로 생성한 오브젝트 클래스는 사용 시 부모 클래스나 인터페이스를 상속받아 구현하는 형태로 사용함
//오브젝트 클래스로 생성 시 데이터 타입을 지정하지 않으면 최상위인 Any 타입으로 생성됨
//Any 타입에는 아래의 오브젝트 클래스가 가지고 있는 필드인 data와 메소드인 some()이 존재하지 않기 때문에 사용할 수 없음

//오브젝트 클래스 선언 시 부모 클래스를 상속받아 구현
val obj = object : Parent() {
    override var data = 10
    override fun some() {
        println("data: $data")
    }
}

//오브젝트 클래스의 부모 클래스 선언
open class Parent {
    open var data = 10

    open fun some() {
        println("parent data : $data")
    }

}


//일반 클래스
class Obj {
    var data = 10

    fun some() {
        println("data: $data")
    }
}

class MyClass{
//    일반 필드 이므로 객체 생성후 접근 가능
    var field = 100
//companion object {} 로 감싼 클래스의 멤버를 해당 클래스의 이름으로 직접 접근할 수 있도록 함
    companion object{
        var data = 10
        fun some(){
            println("data : $data")
        }
    }
}

fun main() {
// 일반 클래스의 객체 생성 및 멤버 사용
    val obj1 = Obj()
    obj1.some()

    println()
//    오브젝트 클래스의 멤버 사용
    obj.data = 100
    obj.some()

    println()
//    val obj2 = object {
//        var data = 10
//        fun some() {
//            println("data2 : $data")
//        }
//    }
//
//    obj2.some()

//    컴페니언 클래스의 멤버 이므로 클래스 이름으로 직접 접근
    MyClass.data = 1000
    MyClass.some()

//객체 생성 후 필드에 접근
    val myclass = MyClass()
    myclass.field = 10000
//    객체명.멤버명 형태로 컴페니언 클래스의 멤버에 접근은 불가능함
//    myclass.data = 100
//    myclass.some()
}