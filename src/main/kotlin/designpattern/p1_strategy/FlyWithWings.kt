package designpattern.p1_strategy

class FlyWithWings : FlyBehavior {
    override fun fly() {
        println("날개로 날아요.")
    }
}