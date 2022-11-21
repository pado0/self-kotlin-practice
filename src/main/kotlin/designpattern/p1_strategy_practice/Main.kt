package designpattern.p1_strategy_practice

class Main {

}

fun main() {
    // 대상 구현체 / 추상화륾 만든다
    // 행동 구현체 / 추상화를 만든다
    // 구현체 RealDuck에서 어떤 Flyable을 적용할지 고른다 - 대상 구현체에서 어떤 행동 구현체를 사용할지 정한다. 대상 추상화는 어떤 행동을 할지 행동 추상화에 위임한다.


    RealDuck().performFly()
}