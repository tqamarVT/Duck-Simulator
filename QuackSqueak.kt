package ducksim

class QuackSqueak : QuackBehavior {
    override val state: State = State.QUACKING
    override val quackText: String = "Squeak!"
}