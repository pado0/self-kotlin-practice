package effectivekotlin

import java.lang.reflect.Array.get
import java.util.*
import kotlin.concurrent.thread

class item1 {
}
fun main() {
//    p5_thread()
//    p8_readroperty()

//    println(fizz)
//    println(fizz2)
//    println(buzz)
//    println(buzz)

//    p11_array_list_arraylist()
//    p14_mutable_change_collection_element()
    p15_custom_immutable_object()
}


fun p5_thread(){
    var num = 0
    for(i in 1..1000)
        thread{
            Thread.sleep(10)
            num += 1
        }

    Thread.sleep(5000)
    println("num = $num")
}
fun p8_readroperty(){

    /* val에 컬렉션 담기 테스트 */

    val list = mutableListOf(1, 2, 3) // val에도 mutable list 할당 가능
    var list2 = mutableListOf(4, 5, 6)

    list.add(4) // val 이지만 가변 리스트이기 떄문에 add 가능
    // list = list2 // list는 val이므로 재할당 불가
    list2 = list // list2는 var이므로 재할당 가능

    println("list2 = $list2")
    println(p8_var_in_val().c)

}

class p8_var_in_val{
    /* val에 var 변수 get하기 테스트 */
    var a: String = "kim"
    var b: String = "hyojin"
    val c
        get() = a + b

}

fun p9_calculate(): Int{
    print("계산중입니다")
    return 42
}

// static 변수라 초기화할 때 p9_calculate() 메소드 호출하므로 "계산중입니다"를 두 번 출력함 (fizz, fizz2 각각 한 번 씩)
//val fizz = p9_calculate()
//val fizz2 = p9_calculate()
val buzz
    get() = p9_calculate()


fun p10_nullable(){
    val name: String? = "a"
    val surname: String = "b"

    var fullname: String? = "abc"

    // if(name.isEmpty()) return // name이 Nullable이므로 오류

    if(name != null) {
        if (name.isEmpty()) return // name이 Nullable이지만 Null 아닌것이 확실하므로 non nullable로 처리
    }

    if (fullname != null) {
        if(fullname.isEmpty()) return
    }
}

fun p11_array_list_arraylist(){

    /* array: 연속된 메모리 공간을 사용. 초기화와 동시에 size가 정해짐. */
    val arr = arrayOf(3, 1, 2) // array는 변경불가. 참조변수 자체에 원소를 집어넣는 add() 대신 리턴값이 있는 plus()를 제공한다
    val copy_arr = arr.plus(4) // plus() 연산으로 계산된 어레이를 다시 할당하지 않으면, 더해진 값이 저장되지 않는다.
    println(Arrays.toString(copy_arr))
    println(Arrays.toString(copy_arr.sortedArray())) // sortedArray로 정렬이 가능하다

    /* list : 불연속적인 메모리 공간을 점유. 값 삽입이 가능. list = immutable list임. */
    val list = listOf(3, 1, 2)
    println(list.plus(4))
    println(list) // array와 마찬가지로 값이 저장되지 않음

    /* arraylist */
    val arrlist = arrayListOf(4, 1, 2)
    println(arrlist.add(3))
    println(arrlist) // arraylist에 3이 add됨.
    println(arrlist.sort()) // Unit을 리턴
    println(arrlist.sorted()) // List를 리턴
}

data class FullName (
    var name: String
) : Comparable<FullName>{
    override fun compareTo(other: FullName): Int {
        return 0 // person in names에서 비교시 어떤 값을 리턴할지 결정한다.
    }
}

fun p14_mutable_change_collection_element(){
    // 요소에 수정이 일어나면 테이블 내에서 요소를 찾을 수 없게 됨
    val names = TreeSet<FullName>()
    val person = FullName("aaa")

    names.add(person)
    names.add(FullName("bbb"))
    names.add(FullName("ccc"))

    println(names)
    println(person in names)

    person.name = "azz"
    println(names)
    println(person in names)
}

fun p15_custom_immutable_object(){
    var user = User("A", "aaa")
    var user2 = user.changeSurname("bbb")
    println(user)
    println(user2)

    var user3 = user.copy("ccc")
    print(user3)
}
data class User(
    val name: String,
    val surname: String,
){
    fun changeSurname(surname: String) = User(this.name, surname)
}