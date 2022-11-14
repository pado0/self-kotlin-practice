package designpattern.p1_strategy_practice

class RealDuck(
    flyable: Flyable = FlyWithRocket(),
    quackable: Quackable = QuackWithThroat(),
) : Duck()