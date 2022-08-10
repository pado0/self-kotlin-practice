package effectivekotlin

class item43 {
}

class Workshop{
    fun makeEvent() = println("멤버함수")
    val permalink
        get() = "workshopname"

}


fun Workshop.makeEventExt() = println("확장함수")
val Workshop.permalinkExt
    get() = "workshopname2"

open class C
class D: C()
fun C.foo() = "c"
fun D.foo() = "d"

fun main() {
    val workshop = Workshop()
    workshop.makeEvent()
    workshop.makeEventExt()

    val d = D()
    println(d.foo())
    val c: C = d
    println(c.foo())

    println(D().foo())

}