data class Event(val title: String, val description: String?, val daypart: DAYPART, val duration: Int)

enum class DAYPART {
        MORNING, AFTERNOON, EVENING
}

fun main() {
    val event = Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day",
        daypart = DAYPART.EVENING,
        duration = 15,
    )
    val events = listOf<Event>(event)

    print(  "title=${events[0].title}," +
            " description=${events[0].description}," +
            " daypart=${events[0].daypart}," +
            " durationInMinutes=${events[0].duration}")
}