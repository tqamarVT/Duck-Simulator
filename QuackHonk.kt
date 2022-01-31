package ducksim

class QuackHonk(private val goose: Goose) : QuackBehavior {
    override val state: State = State.QUACKING
    override val quackText: String = goose.honkText
}