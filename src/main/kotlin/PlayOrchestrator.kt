import java.util.*

class PlayOrchestrator(private val actors: MutableList<Actor>, private val eventOrchestrator: EventOrchestrator): ReceiverPublisher {
    private val subscribedEvent = "toPlayOrchestrator"
    private val name = "PlayOrchestrator"
    private val toAll = "toAll"
    private val actorsDone = mutableListOf<String>()

    init {
        eventOrchestrator.subscribe(subscribedEvent, this)
    }

    fun start() {
        publish(Event(toAll, name, "**PLAY STARTS**"))
        val firstActorName = actors[0].name
        publish(Event("to$firstActorName", name, ""))
    }

    override fun receive(event: Event) {
        val timer = Timer()
        val task = object : TimerTask() {
            override fun run() {
                handleEvent(event)
            }
        }
        timer.schedule(task, 100)
    }

    private fun isLastLineDelivered(actorName: String):Boolean {
        actorsDone.add(actorName)
        return actorsDone.size == actors.size
    }

    fun handleEvent(event: Event) {
        if(isLastLineDelivered(event.from)) {
            publish(Event(toAll, name, "**PLAY COMPLETED**"))
        }
        return
    }

    override fun publish(event: Event) {
        eventOrchestrator.notify(event)
    }
}
