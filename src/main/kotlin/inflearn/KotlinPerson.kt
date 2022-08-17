// 디폴트가 public
// 프로퍼티: 필드 + getter + setter. 코틀린은 필드만 만들면 getter, setter를 자동으로 만들어줌
class KotlinPersonV1 (name:String, age:Int){
    val name = name
    var age = age

}

// 생성자는 클래스 옆에 선언. constructor 지시어 생략 가능
class KotlinPersonV2 constructor(name:String, age:Int){
    val name = name
    var age = age
}

// 생성자에서 프로퍼티를 만들어줄 수 있어서, 필드 생략 가능.
// feature 수정 1-1
class KotlinPersonV3 (val name: String, var age: Int)

class KotlinPersonV4 (val name: String, var age: Int){
    init {
        println("init 블록")
        if(age <= 0) throw java.lang.IllegalArgumentException("나이는 $age 일 수 없습니다")
    }

    constructor(name: String) : this(name, 1){
        println("1번 부생성자")
    }

    constructor() : this("홍길동"){
        println("2번 부생성자")
    }
}

class KotlinPersonV5 (val name: String, var age: Int){
    // 방법1. 함수 직접 만들기
    fun isAdult(): Boolean{
        return this.age >= 20
    }
    // 방법2. 커스텀 게터 사용. 프로퍼티처럼 만들기. 속성이면 이방법, 속성이 아니면 함수로!
    val isAdultByGetter: Boolean
        get() = this.age >= 20
}

class KotlinPersonV6 (
    val name: String = "김효진",
    var age: Int = 1){


    val uppercase: String
        get() = this.name.uppercase()
}

class KotlinPersonV7 (
    name: String = "김효진",
    var age: Int = 1){

    var name = name
        set(value) {
            field = value.uppercase()
        }

}


// .필드를 통해 getter, setter를 바로 호출할 수 있다.
fun main() {

    val person4 = KotlinPersonV4()

}