package designpattern.p2_observer

class CurrentConditionsDisplay(
    val temperature: Long,
    val humidity: Long,
    val weatherData: WeatherData
) : Observer, DisplayElement {

    constructor(weatherData: WeatherData) : this(weatherData = weatherData, temperature = 1, humidity = 1){
        weatherData.registerObserver(this)
    }

    override fun update(temp: Long, humidity: Long, pressure: Long) {
        TODO("Not yet implemented")
    }
    override fun display() {

    }

}