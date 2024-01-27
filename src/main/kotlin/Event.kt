open class Event(val name: String, val from: String, val message: String, val type: EventType = EventType.BASIC)

enum class EventType {
    BASIC,
    ENTERING_EVENT,
    EXITING_EVENT
}
