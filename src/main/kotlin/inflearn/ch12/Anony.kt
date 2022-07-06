package inflearn.ch12

fun main() {
    moveSomething(object : Movable {
        override fun move() { println("움직임") }
        override fun fly() { println("날기") }
    })
}

private fun moveSomething(moveable: Movable) {
    moveable.move()
    moveable.fly()
}