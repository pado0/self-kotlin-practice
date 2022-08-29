package effectivekotlin

fun main() {
    val name: Name = Name("string")
    println(name.value)
}
class Item47 {
}

inline class Name(val value: String){

}