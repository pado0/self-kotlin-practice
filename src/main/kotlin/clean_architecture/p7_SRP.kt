package clean_architecture

import java.util.StringJoiner

// 파사드 패턴을 구현해본다.

fun beforeFacade_watchingMovie(){
    val baverage = Beverage("콜라")
    val remoteControl = RemoteControl()
    val movie = Movie()

    /*
        아래의 명령을 하나하나 실행하기 복잡하다.
     */
    baverage.prepare() // 음료 준비
    remoteControl.turnOn() // 켜기
    movie.search() // 찾기
    movie. watch() // 보기
}

fun afterFacade_watchingMovie(){
    val facade = Facade(movieName = "영화명")
    facade.viewMovie()
}

data class Beverage(
    val name: String,
){
    fun prepare() = "준비"
}
class RemoteControl{
    fun turnOn() = "on"
    fun turnOff() = "off"
}
class Movie{
    fun watch() = "보다"
    fun search() = "찾다"
}

class Facade(
    val movieName: String,
){
    val baverage = Beverage("콜라")
    val remoteControl = RemoteControl()
    val movie = Movie()

    fun viewMovie() {
        baverage.prepare() // 음료 준비
        remoteControl.turnOn() // 켜기
        movie.search() // 찾기
        movie.watch() // 보기
    }
}