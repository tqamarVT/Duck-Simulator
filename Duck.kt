package ducksim

import java.awt.Color

abstract class Duck : Observer {

    // values that can be overridden
    open val color: Color = Color.BLACK
    open val defaultFlyBehavior: FlyBehavior = FlyWithWings()
    open val defaultQuackBehavior: QuackBehavior = QuackNormal()

    //
    open var currentFlyBehavior = defaultFlyBehavior
    open var currentQuackBehavior = defaultQuackBehavior
    open var quackText: String = "Quack!"
    // variables that can be changed only by functions in this class

    var state = State.SWIMMING
        private set
    var isFree = true
        private set
    var isOnDSWC = false
        private set

    // function for setting the state back to its default (swimming)

    fun swim() {
        state = State.SWIMMING
    }

    // functions from the context menu

    open fun fly() {
        state = currentFlyBehavior.state
    }

    open fun quack() {
        state = currentQuackBehavior.state
    }

    val joinDSCW = object : DuckMenuItem {
        override fun invoke() {
            joinDSCWHelper()
        }
    }

    val quitDSCW = object : DuckMenuItem {
        override fun invoke() {
            quitDSCWHelper()
        }
    }

    val capture = object : DuckMenuItem {
        override fun invoke() {
            isFree = false
            currentFlyBehavior = FlyNoWay()
            currentQuackBehavior = QuackNoWay()

        }
    }

    val release = object : DuckMenuItem {
        override fun invoke() {
            isFree = true
            currentFlyBehavior = defaultFlyBehavior
            currentQuackBehavior = defaultQuackBehavior
        }
    }

    // Interface function that must be implemented here
    override fun update() {
        state = State.WELCOMING
    }

    // abstract display function that must be implemented by concrete classes

    abstract fun display(): String

    // private functions to help with adding observers to the DuckFactory for the joinDSCW and quitDSCW functions
    private fun joinDSCWHelper() {
        isOnDSWC = true
        DuckFactory.instance.registerObserver(this)
    }

    private fun quitDSCWHelper() {
        isOnDSWC = false
        DuckFactory.instance.removeObserver(this)
    }


}
