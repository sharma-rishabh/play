class EvenOrchestrator {
    private val eventMap: MutableMap<String, MutableList<ReceiverPublisher>> = mutableMapOf()

    private fun isEventRegistered(eventName: String):Boolean {
        return eventMap.containsKey(eventName)
    }

    fun subscribe(eventName: String, listener: ReceiverPublisher) {
        println("Subscribed to $eventName")
        if(isEventRegistered(eventName)) {
            eventMap[eventName]!!.add(listener)
            return
        }
        eventMap[eventName] = mutableListOf(listener)
        return
    }

    fun notify(event: Event) {
        if(!isEventRegistered(event.name)) {
            println("NO SUCH EVENT REGISTERED ${event.name}")
            return
        }
        eventMap[event.name]!!.map {
            it.receive(event)
        }
    }
}
