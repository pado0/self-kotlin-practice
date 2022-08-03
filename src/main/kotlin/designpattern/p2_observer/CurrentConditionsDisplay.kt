package designpattern.p2_observer

class CurrentConditionsDisplay : Observer, DisplayElement {
    override fun display() {

    }

    override fun update(temp: Long, humidity: Long, pressure: Long) {
        TODO("Not yet implemented")
    }
}