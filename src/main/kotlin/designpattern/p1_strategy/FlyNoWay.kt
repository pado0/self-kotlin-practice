package designpattern.p1_strategy

class FlyNoWay : FlyBehavior {
    override fun fly() {
        println("날지 않습니다.")
    }
}