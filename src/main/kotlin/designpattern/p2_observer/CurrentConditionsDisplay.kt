package designpattern.p2_observer

class CurrentConditionsDisplay(
    var temperature: Long? = null,
    var humidity: Long? = null,
    var weatherData: WeatherData
) : Observer, DisplayElement {

    constructor(weatherData: WeatherData) : this(null, null, weatherData = weatherData){
        weatherData.registerObserver(this)
    }

//    override fun update(temperature: Long, humidity: Long, pressure: Long) {
//        this.temperature = temperature
//        this.humidity = humidity
//
//        display()
//    }

    // update 호출시 weather data로부터 데이터를 가져오도록 pull
    override fun update() {
        this.temperature = weatherData.temperature
        this.humidity = weatherData.humidity
        display()
    }

    override fun display() {
        println(temperature)
        println(humidity)

    }


}