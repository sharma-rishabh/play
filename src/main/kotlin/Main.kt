fun main(args: Array<String>) {
    val eventOrchestrator = EventOrchestrator()
    val juliusLines = listOf(
        Line("Brutus", "hi"),
        Line("Brutus", "Why do you look wierd"),
        Line("Brutus", "No Brutus don't do this."),
        Line("Brutus", "ET TU BRUTUS."),
    )
    val brutusLines = listOf(
        Line("Julius", "hello"),
        Line("Julius", "Nothing's the matter Julius *Takes out his knife*"),
        Line("Julius", "*STAB*"),
        Line("Julius", "Sorry."),
    )

    val actors = mutableListOf(
        Actor("Julius", eventOrchestrator, juliusLines),
        Actor("Brutus", eventOrchestrator, brutusLines)
    )

    PlayOrchestrator(actors, eventOrchestrator).start()
}
