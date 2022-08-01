package designpattern.p1_strategy

class MallardDuck(
    quackBehavior: QuackBehavior = Quack(), // 특정 클래스에 종속되지만, 일단 이전보다 변경이 쉽긴 한다. // 생성시 초기화를 해줘야 상속받은 변수가 세팅된다. 혹은 MallardDuck의 생성자에서 변수를 받던가. 그래서 val이 못붙음
    flyBehavior: FlyBehavior = FlyWithWings()
) : Duck(
    quackBehavior,
    flyBehavior
)
