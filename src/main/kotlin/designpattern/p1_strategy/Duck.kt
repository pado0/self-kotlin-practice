package designpattern.p1_strategy

open class Duck(
    var quackBehavior: QuackBehavior, // 갈아끼울 수 있도록 행위를 인 인스턴스 변수로 가진다.
    var flyBehavior: FlyBehavior
) {

    fun performQuack(){
        quackBehavior.quack() // 꽥꽥거리는 행동을 직접 구현하는 대신, 입력으로 들어온 타입의참조 객체에 행동을 위임한다.
    }

    fun performFly(){
        flyBehavior.fly()
    }

}
