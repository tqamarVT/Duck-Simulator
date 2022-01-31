package ducksim

import java.awt.Color

class RubberDuck : Duck() {

    override val color: Color = Color.YELLOW
    override val defaultFlyBehavior: FlyBehavior = FlyNoWay()
    override val defaultQuackBehavior: QuackBehavior = QuackSqueak()
    override var currentFlyBehavior = defaultFlyBehavior
    override var currentQuackBehavior = defaultQuackBehavior
    override var quackText: String = currentQuackBehavior.quackText

    override fun display() = "Rubber"
}