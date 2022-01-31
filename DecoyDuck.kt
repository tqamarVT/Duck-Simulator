package ducksim

import java.awt.Color

class DecoyDuck : Duck() {
    override val color: Color = Color.ORANGE
    override val defaultFlyBehavior: FlyBehavior = FlyNoWay()
    override val defaultQuackBehavior: QuackBehavior = QuackNoWay()
    override var currentFlyBehavior = defaultFlyBehavior
    override var currentQuackBehavior = defaultQuackBehavior
    override var quackText: String = currentQuackBehavior.quackText

    override fun display() = "Decoy"
}
