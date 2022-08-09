package weakness.backingfield

fun main() {
    UseBackingField().name = "test"

}
/*class NotUseBackingField {
    var name: String
        get() = name
        set(value) {name = value} // name = value를 대입하는 과정에서 set name을 하게 되어 무한 순환
}*/

/** 코틀린에서 필드는 값을 메모리에 저장하기 위한 프로퍼티의 한 요소이다.
 * 필드는 바로 선언될 수 없다. (무조건 프로퍼티로 선언된다, var / val)
 * 하지만, 프로퍼티가 backing field가 필요하다면 코틀린은 이를 자동으로 생성해준다.
 * backing field는 field 예약어를 통해 접근할 수 있다.
 */

class UseBackingField {
    var name: String = ""
        get() = field
        set(value) {field = value}
}

