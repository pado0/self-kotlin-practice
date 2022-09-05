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

fun main() {
    val fruit = receiveFruits(arrayOf(Fruit(), Fruit()))
    val appleAndBanana = receiveFruits(arrayOf(Apple(), Banana()))

    apple[1] = Apple()
    appleAndBanana[1] = Banana()

    receiveFruitsList(listOf(Apple(), Apple()))
    receiveFruitsList()

}
