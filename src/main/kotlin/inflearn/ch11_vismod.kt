package inflearn

val a = 3

fun add(a: Int, b: Int): Int = a + b

class Cat private constructor()

fun idDirectoryPath(path: String): Boolean{
    return path.endsWith("/")
}


class Car(
    internal val name: String, // getter에 internal
    private var owner: String, // get, setter에 private
    _price: Int
){
    var price = _price // price의 get은 public
        private set // price의 set은 Private
}