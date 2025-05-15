data class Event(val title: String, val description: String?, val dayPart: DayPart, val duration: Int) {
}

val Event.durationOfEvent: String
    get() = if (duration < 60) {
        "short"
    } else {
        "long"
    }

enum class DayPart {
    MORNING,
    AFTERNOON,
    EVENING
}

fun main() {
    val events: MutableList<Event> = mutableListOf<Event>()
    events.add(Event("Study Kotlin", "Commit to studying Kotlin at least 15 minutes per day.", DayPart.EVENING, 15))
    events.add(Event("Study Kotlin", "Commit to studying Kotlin at least 15 minutes per day.", DayPart.MORNING, 49))
    events.add(Event("Study Kotlin", "Commit to studying Kotlin at least 15 minutes per day.", DayPart.MORNING, 90))
    val shortEvents = events.filter { it.duration < 60 }
    println("短いイベントが${shortEvents.size}件あります。")

    events.groupBy {
        it.dayPart
    }.forEach {
        println("${it.key}: ${it.value.size} events")
    }

    println("Last event of the day: ${events.last().title}")

    println("Duration of first event of the day: ${events[0].durationOfEvent}")
}