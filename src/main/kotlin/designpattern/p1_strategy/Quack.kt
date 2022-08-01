package designpattern.p1_strategy

class Quack : QuackBehavior {
    override fun quack() {
        println("꽥 거리는 소리")
    }
}