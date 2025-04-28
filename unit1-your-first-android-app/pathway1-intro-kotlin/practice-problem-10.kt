fun main() {
    println(isTodayUsageMoreThanYesterday(30, 20))
    println(isTodayUsageMoreThanYesterday(10, 20))
}

fun isTodayUsageMoreThanYesterday(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}