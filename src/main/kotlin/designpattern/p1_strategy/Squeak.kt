package designpattern.p1_strategy

class Squeak : QuackBehavior{
    override fun quack() {
        println("삑삑거리는 소리")
    }

}