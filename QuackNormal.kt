package ducksim

class QuackNormal : QuackBehavior {
    override val state: State = State.QUACKING
    override val quackText: String = "Quack!"

}