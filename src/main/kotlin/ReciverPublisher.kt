interface ReceiverPublisher {
    fun receive(event: Event)
    fun publish(event: Event)
}
