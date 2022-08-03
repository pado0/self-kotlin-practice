package designpattern.p2_observer

fun main() {

    var weatherData = WeatherData(10, 20, 30)

    // weatherDate의 옵저버로 등록요청
    // weatherData가 가진 리스트 내에 옵저버로 등록됨
    var currentConditionsDisplay = CurrentConditionsDisplay(weatherData)

    // setMeasurement 함수 호출시 (데이터가 변경되었을 시) observer에게 notify가 가고, 이때 옵저버들의 update 함수가 호출되며 결과출력
    weatherData.setMeasurements(20,20, 20) // 주제가 변경될 때 마다 옵저버들에게 노티를 준다
    weatherData.setMeasurements(30,30, 30)

}