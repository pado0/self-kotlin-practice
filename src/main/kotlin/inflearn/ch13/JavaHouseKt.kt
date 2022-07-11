package inflearn.ch13

import inflearn.ch13.JavaHouse.LivingRoom

class JavaHouseKt (
    val address: String,
    val livingRoom: LivingRoom
){
    class LivingRoom(
        // 그냥 클래스 만들듯 하면 된다.
        private val araa: Double // 자바에서 제안하는 권장되는 static 중첩클래스를 코틀린으로 구현한 것.
    )

    inner class LivingRoomNotOffered(
        private val area: Double
    ){
        val agree: String
            get() = this@JavaHouseKt.address // 권장되지 않는 상위 클래스 접근시엔 this@상위클래스타입.필드명으로 가져와야함
    }
}