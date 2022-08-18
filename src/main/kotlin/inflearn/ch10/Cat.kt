package inflearn.ch10

//test2
// Cat클래스 만들어줌. species를 받는 생성자 생성
class Cat(
    species: String
// 애니멀 클래스를 상속받을때 애니멀 클래스의 생성자를 species, 4 넣어 바로 호출
) : Animal(species, 4) {
    override fun move() {
        println("사뿐사뿐 코틀린 고양이")
    }
}
// m3