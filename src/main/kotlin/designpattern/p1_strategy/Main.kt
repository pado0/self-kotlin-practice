package designpattern.p1_strategy

fun main() {
    // 바꾸고자 하는 동작은 인터페이스로, 우는행위 / 나는 행위
    // 이를 사용하고자 하는 고객, 클라이언트는 오리(Duck), MallardDuck 클래스
    // 오리는 행위의 다형성 (Behavior 인터페이스)을 통해 직접 행위를 갈아 끼워 사용할 수 있다.

    // duck은 매개변수로 갈아끼우듯 객체를 받은 것
    val duck = Duck(Quack(), FlyNoWay()) // 꽥꽥거리는 행동을 직접 구현하는 대신, 입력으로 들어온 타입의참조 객체에 행동을 위임한다.
    duck.performQuack()
    duck.performFly()

    // mallerDuck은 이미 Quack(), FlyWithWings()로 객체를 끼우기로 한 것
    val mallardDuck = MallardDuck()
    mallardDuck.performQuack()
    mallardDuck.performFly()

    // 동적으로 움직이는 오리 호출하기, 실행 중 오리의 행동을 바꾸고 싶다.
    val duckDynamic = MallardDuck()
    duckDynamic.flyBehavior = FlyWithWings() // 나는 오리로 만들기
    duckDynamic.performFly()
    duckDynamic.flyBehavior = FlyNoWay() // 날지 못하는 오리로 만들기
    duckDynamic.performFly()
}