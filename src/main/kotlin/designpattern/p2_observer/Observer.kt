package designpattern.p2_observer

interface Observer {
    fun update(temp:Long, humidity:Long, pressure:Long)
}