package toenhance.enum

enum class Animal(
    private val typeList: List<Int>, // 상수의 프로퍼티를 정의
    private val color: String,
) {
    TIGER(listOf(1, 2, 3), "red"), // Animal 타입의 Enum 상수 생성. 생성시 프로퍼티 지정.
    BEAR(listOf(2, 4), "brown"); // 세미콜론 필수!

    fun sizesSum() = typeList.sum() // 공통 사용될 메소드 만들기
    fun getColor() = color

}

fun getPlaceByAnimal(animal: Animal) =
    when(animal){
        Animal.BEAR -> "amazon"
        Animal.TIGER -> "savana"
    }

fun main() {
    println(Animal.BEAR.sizesSum()) // 메소드 사용
    println(getPlaceByAnimal(Animal.TIGER))
}