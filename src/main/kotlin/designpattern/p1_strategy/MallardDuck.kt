package designpattern.p1_strategy

class MallardDuck(
    quackBehavior: QuackBehavior = Quack(), // 특정 클래스에 종속되지만, 일단 이전보다 변경이 쉽긴 한다.
    flyBehavior: FlyBehavior = FlyWithWings()
) : Duck(
    quackBehavior,
    flyBehavior
)
