package com.bitc.app1227

//함수 hofFun의 반환 타입을 함수 타입으로 설정
//반환 타입으로 설정된 함수는 매개변수는 없고 반환값은 String인 함수

//함수 hofFun의 매개변수를 함수 타입으로  설정
//매개변수로 설정된 함수는 Int 타입의 매개변수가 1개 있고, 반환 타입은 Boolean 타입인 함수
//hofFun 실행 시 매개변수가 val arg:(Int)->Boolean = {no:Int -> no>0}형태가 됨
fun hofFun(arg:(Int)->Boolean): ()-> String{
//코틀린에서는 if문을 표현식으로 사용하는 것이 가능함
//    arg(10)은 {no:Int-> no>0}의 람다 함수가 동작하는 것 이므로 결과가 true가 출력
//    변수 result 에 if문을 결과를 반환(invalid 반환)
    val result = if (arg(10)){
        "valid"
    }else{
        "invalid"
    }
//    함수 hofFun의 반환 ,return 키워드 뒤에 람다 함수를 입력, hofFun의 반환 타입을 ()->String 함수 형태로 지정을 했기 때문
//    매개변수가 없는 람다 함수를 반환
    return {"hofFun result: $result"}
}

fun main(){
//    변수 result에 저장된 것은 매개변수가 없고 반환값이 String인 함수
//    hofFun 실행 시 매개변수로 람다 함수 전달
    val result= hofFun { no->no>0 }
//    변수 result 에 () 를 붙여서 함수를 호출
    println(result())

//    String 타입의 변수 선언, 데이터 타입에 ? 가없기 때문에 NULL 불 허용
    var result2:String = "ㅎㅇ"
    println(result2.length)
//    변수에 빈 문자열 입력
    result2=""
    println(result2.length)
//    변수에 null입력, 오류 발생, 데이터 타입에 ?가 없어서 null을 입력하지 못함
//    result2=null


//    String 타입의 변수 선언, 데이터 타입에 ?를 사용하여 NULL을 허용
    var result3:String?="ㅎㅇ"
//    데이터 타입에 ? 를 사용하여 null을 허용할 경우 각종 메소드 사용시 '?.'명령어를 사용해야함
    println(result3?.length)

    result3=""
    println(result3?.length)
//    데이터 타입에 ?을 사용한 변수 이므로 null을 저장할 수있음
    result3=null
//    저장된 값이 null인지 아닌지를 확인하여 null일 경우 메소드 결과를 null로 출력,아니면 원본 결과값을 출력
    println(result3?.length)

    println("\n-----------앨비스 연산자 ------------\n")
//    String 타입의 변수 data 선언, ?를 사용하여 null 허용 변수로 선언
    var data:String? = "ㅎㅇ"
    println("변수 data : $data")

//    해당 변수가 null 허용 변수 이므로 null도 저장 가능
    data = null
    println("변수 data : $data")

    data ="ㅎㅇㅂㅇ"
//    '?.' 연산자를 사용하여 변수 data의 멤버를 안전하게 사용
//    '?:' 연산자는 해당 변수 사용 시 안전하게 사용하도록 하며, 기본값을 설정하여 사용
//    '?:' 연산자 사용시 변수의 값이 존재하면 해당 변수의 값 및 멤버를 사용하고, 값이 null일 경우 사용자가 지정한 기본값을 사용
    println("변수 data : $data : ${data?.length?:0}")

    data = null
//    변수 data의 값이 null이므로 변수 data의 멤버를 사용하지 못하고 null만 출력됨
//    '?:' 를 사용하면 지정한 변수가 null일 경우 사용할 기본값을 설정하고 출력할 수 있음
    println("변수 data : $data : ${data?.length?:0}")

    println("\n-----------예외 발생 시키기------------\n")

    println(some("ㅎㅇ"))

    println(some(null))

}
fun some(data:String?):Int{
    return data!!.length
}