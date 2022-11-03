package effectivekotlin

import java.lang.reflect.Array.get
import kotlin.concurrent.thread

class item1 {
}
fun main() {
//    p5_thread()
//    p8_readroperty()
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