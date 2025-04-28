fun main() {
    printWeatherSummaryForCity("Ankara", 27, 31, 82)
    printWeatherSummaryForCity("Tokyo", 32, 36, 2)
    printWeatherSummaryForCity("Cape Town", 59, 64, 2)
    printWeatherSummaryForCity("Guatemala City", 50, 55, 7)
}

fun printWeatherSummaryForCity(city: String, lowTemp: Int, highTemp: Int, chanceOfRain: Int) {
    println("City: $city")
    println("Low temperature: $lowTemp, High temperature: $highTemp")
    println("Chance of rain: $chanceOfRain%")
    println()
}