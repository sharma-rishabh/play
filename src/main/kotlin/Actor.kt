import java.util.*

class Actor(val name: String, private val eventOrchestrator: EventOrchestrator, private val lines: List<Line>) :
    ReceiverPublisher {

    private var currLineIndex = 0
    private val subscribedEvent = "to$name"
    private val toPlayOrchestrator = "toPlayOrchestrator"
    init {
        eventOrchestrator.subscribe(subscribedEvent, this)
    }

    override fun receive(event: Event) {
        val timer = Timer()
        val task = object : TimerTask() {
            override fun run() {
                publishNextLine()
            }
        }
        timer.schedule(task, 3000)
    }

    fun publishNextLine() {
        val currentLine = lines[currLineIndex]
        currLineIndex += 1
        val event = Event("to${currentLine.to}", name, currentLine.message)
        publish(event)

        if (currLineIndex == lines.size) {
            eventOrchestrator.notify(Event(toPlayOrchestrator, name, "", EventType.EXITING_EVENT))
            eventOrchestrator.unsubscribe(subscribedEvent, this)
        }
    }

    override fun publish(event: Event) {
        eventOrchestrator.notify(event)
    }
}
