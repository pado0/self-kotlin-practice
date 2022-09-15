package toenhance.generics

open class Fruit
class Apple : Fruit()
class Banana : Fruit()

fun receiveFruits(fruits: Array<Fruit>){
    println("${fruits.size}")
}

fun receiveFruitsList(fruits: List<Fruit>){
    println("${fruits.size}")
}

// 지네릭 함수
fun <T> addNumbers(num1: T, num2: T): T{ // 함수 정의시 타입이 정해지지 않은 변수는 이름 앞에 <T>처럼 정의해야함.
    return ("${num1.toString()} , ${num2.toString()}" ) as T
}

// 지네릭 클래스
class Rectangle<T: Number>(val width:T, val height:T) // 어떤 타입이든 받을 수 있는 클래스


// 공변 지네릭 클래스 (out 키워드 사용)
class CovOutRectangle<out T: Number>(val width:T, val height:T)

// 공변 지네릭 클래스 (in 키워드 사용)
class CovInRectangle<in T: Number>(val width: @UnsafeVariance T, val height: @UnsafeVariance T)


fun main() {
    val fruit = receiveFruits(arrayOf(Fruit(), Fruit()))
    val appleAndBanana = receiveFruits(arrayOf(Apple(), Banana()))
    receiveFruitsList(listOf(Apple(), Apple()))

    val doubleRectangle = Rectangle(10.0, 20.0) // 같은 타입변수에 다른 타입을 줘도 정상 동작한다. why?
    println(doubleRectangle.width)
    println(doubleRectangle.width is Double)
    // println(doubleRectangle.height is String)
    // val stringRectangle = Rectangle<String>("aa", "bb") // number만 가능하도록 제한

    val derivedClass = CovOutRectangle<Double>(19.2, 39.4)
    val baseClass : CovOutRectangle<Number> = derivedClass // 공변성으로, 상위클래스 타입변수 호환이 가능하다

    val inBaseClass = CovInRectangle<Number>(10.25, 10.23)
    val inDerivedClass : CovInRectangle<Double> = inBaseClass


}
public inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
    return filterTo(ArrayList<T>(), predicate)
}

