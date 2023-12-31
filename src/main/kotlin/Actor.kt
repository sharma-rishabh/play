import java.util.*

class Actor(val name: String, val eventOrchestrator: EvenOrchestrator, val lines: List<Line>): ReceiverPublisher {

    private var currLineIndex = 0
    init {
        eventOrchestrator.subscribe("to$name", this)
    }
    override fun receive(event: Event) {
        println(event.message)

        val timer = Timer()
        val task = object: TimerTask() {
            override fun run() {
                publish()
            }
        }
        timer.schedule(task, 3000)
    }
    override fun publish() {
        val currentLine = lines[currLineIndex]
        println("From $name to ${currentLine.to}")
        currLineIndex += 1
        val event = Event("to${currentLine.to}", currentLine.message)
        eventOrchestrator.notify(event)
    }
}
