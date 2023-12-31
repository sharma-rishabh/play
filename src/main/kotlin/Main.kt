fun main(args: Array<String>) {
    val eventOrchestrator = EvenOrchestrator()
    val juliusLines = listOf(
        Line("Brutus", "hi"),
        Line("Brutus", "Why do you look wierd"),
        Line("Brutus", "No Brutus don't do this."),
        Line("Brutus", "AHHHHHHHHH."),
    )
    val brutusLines = listOf(
        Line("Julius", "hello"),
        Line("Julius", "Nothing's the matter Julius *Takes out his knife*"),
        Line("Julius", "*STAB*"),
        Line("Julius", "Sorry ."),
    )

    val julius = Actor("Julius", eventOrchestrator, juliusLines)
    Actor("Brutus", eventOrchestrator, brutusLines)

    julius.publish()
}
