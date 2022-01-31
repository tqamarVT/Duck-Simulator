package ducksim

class QuackNoise : QuackBehavior {
    override val state: State = State.QUACKING
    override val quackText: String = "Noise!"
}