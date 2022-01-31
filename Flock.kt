package ducksim

class Flock(private val ducks: List<Duck>) : Duck() {

    override val defaultFlyBehavior: FlyBehavior = FlyWithWings()
    override val defaultQuackBehavior: QuackBehavior = QuackNoise()
    override var currentFlyBehavior = defaultFlyBehavior
    override var currentQuackBehavior = defaultQuackBehavior
    override var quackText: String = currentQuackBehavior.quackText


    fun joinDSCW() {
        for(duck in ducks) {
            duck.joinDSCW()
        }
    }

    fun quitDSCW() {
        for(duck in ducks) {
            duck.quitDSCW()
        }
    }

    fun capture() {
        for(duck in ducks) {
            duck.capture()
        }
    }

    fun release() {
        for(duck in ducks) {
            duck.release()
        }
    }

    override fun display(): String {
        var displayString = "Flock"
        for (duck in ducks) {
            displayString += ":" + duck.display()[0]
        }
        return displayString
    }
}
