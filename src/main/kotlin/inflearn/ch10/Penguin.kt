package inflearn.ch10
// bugfix2
class Penguin (
    species: String
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄코틀린 움직인다")
    }

    // 프로퍼티처럼 보여야함
    // 프로퍼티를 오버라이드할 때 open을 붙여줘야 한다.
    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }



}