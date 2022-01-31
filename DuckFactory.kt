package ducksim

class DuckFactory private constructor() : Subject {
    private val observers: MutableList<Observer> = ArrayList()
    fun createDuck(
        baseDuck: String?, starCount: Int, moonCount: Int,
        crossCount: Int,
    ): Duck? {
        var duck: Duck?
        when (baseDuck) {
            "Mallard" -> duck = MallardDuck()
            "Redhead" -> duck = RedheadDuck()
            "Rubber" -> duck = RubberDuck()
            "Decoy" -> duck = DecoyDuck()
            "Goose" -> duck = GooseDuck(Goose())
            else -> duck = MallardDuck() // This is done to prevent any null pointer errors
        }

        // Apply star bling
        for (starIndex in 0 until starCount) {
            duck = StarBling(duck!!)
        }

        // Apply moon bling
        for (moonIndex in 0 until moonCount) {
            duck = MoonBling(duck!!)
        }

        // Apply cross bling
        for (crossIndex in 0 until crossCount) {
            duck = CrossBling(duck!!)
        }
        notifyObservers()
        return duck
    }

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        val index = observers.indexOf(observer)
        observers.removeAt(index)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update()
        }
    }

    companion object {
        val instance = DuckFactory()
    }
}