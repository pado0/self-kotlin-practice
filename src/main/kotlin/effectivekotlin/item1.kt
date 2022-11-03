package effectivekotlin

class item1 {
}

val fizz = calculate()
val buzz
    get() = calculate()

fun main() {
    var a = "hyo"
    var b = "jin"
    val name = a + b

//    println(name)

    println(fizz)
    println(fizz)
    println(buzz)
    println(buzz)

    val arr: ArrayList<Int> = arrayListOf()
}

fun calculate(): Int{
    print("계산중입니다")
    return 42
}