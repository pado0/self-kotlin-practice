package designpattern.p1_strategy_practice

class FlyWithRocket : Flyable {
    override fun fly() {
        println("로켓으로 납니다.")
    }
}