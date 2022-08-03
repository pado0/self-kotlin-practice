package designpattern.p2_observer

interface Observer {
    //fun update(temp:Long, humidity:Long, pressure:Long)
    // pull 방식으로 리팩토링
    fun update()
}