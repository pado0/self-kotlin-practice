package inflearn.ch10
//master 수정 3
abstract class Animal(
    protected val species: String,
    protected open val legCount: Int
) {
    abstract fun move()
}