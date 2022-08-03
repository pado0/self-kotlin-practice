package designpattern.p2_observer

class WeatherData(
    var temperature: Long,
    var humidity: Long,
    var pressure: Long,
) : Subject{

    var observers = mutableListOf<Observer>()

    override fun registerObserver(o: Observer) {
        observers.add(o)

    }

    override fun removeObserver(o: Observer) {
        observers.remove(o)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            //observer.update(temperature, humidity, pressure) // 옵저버의 함수를 호출

            // Pull 방식으로 리팩토링
            observer.update() // 옵저버의 함수를 호출
        }
    }

    private fun measurementChanged(){
        notifyObservers()
    }

    // 기상 스테이션에서 측정한 값이라고 가정하고 측정치를 set 해준다. set 후에 옵저버틀에게 변경된 값을 고지한다.
    fun setMeasurements(temperature: Long, humidity: Long, pressure: Long) {
        this.humidity = humidity
        this.pressure = pressure
        this.temperature = temperature
        measurementChanged()
    }

}