package designpattern.p1_strategy

class MuteQuack : QuackBehavior {
    override fun quack() {
        println("사실은 울지 않습니다.")
    }

}