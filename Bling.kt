package ducksim

import java.awt.Color

abstract class Bling(var duck: Duck) : Duck() {
    override val color: Color = duck.color
    override val defaultFlyBehavior = duck.defaultFlyBehavior
    override val defaultQuackBehavior = duck.defaultQuackBehavior
    override var currentFlyBehavior = defaultFlyBehavior
    override var currentQuackBehavior = defaultQuackBehavior
    override var quackText: String = duck.quackText
}