package inflearn.ch10
//master 수정 3
// bugfix
abstract class Animal(
    protected val species: String,
    protected open val legCount: Int
) {
    abstract fun move()
}
// m1
// m2