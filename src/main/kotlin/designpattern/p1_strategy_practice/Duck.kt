package designpattern.p1_strategy_practice

open class Duck{

    val flyable: Flyable? = null
    val quackable: Quackable? = null

    // 슈퍼클래스에서 fly(), quack()을 대신 수행한느 애를 선언하는게 핵심
    fun performFly() = flyable?.fly() // Flyable에 fly()를 위임한다.
    fun performQuack() = quackable?.quack()

}