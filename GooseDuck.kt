package ducksim

import java.awt.Color

class GooseDuck(val goose: Goose) : Duck() {
    override val color: Color = Color.BLUE
    override val defaultFlyBehavior: FlyBehavior = FlyWithWings()
    override val defaultQuackBehavior: QuackBehavior = QuackHonk(goose)
    override var currentFlyBehavior = defaultFlyBehavior
    override var currentQuackBehavior = defaultQuackBehavior
    override var quackText: String = currentQuackBehavior.quackText
    override fun display() = goose.name
}