package ducksim


class DuckPond {

    val duckList = mutableListOf<Duck>()
    val selectedDucks = mutableSetOf<Duck>()
    var currentDuck: Duck? = null

    val hasCurrentDuck
        get() = ( currentDuck != null )

    fun addNewDuck(duck: Duck) {
        assert(duckList.size < Companion.MAX_DUCKS)
        duckList.add(duck)
    }

    fun deleteDuck(duck: Duck) {
        if (duck === currentDuck) {
            currentDuck = null
        }
        duckList.remove(duck)
    }

    fun toggleSelection(duck: Duck) {
        if (selectedDucks.contains(duck)) {
            selectedDucks.remove(duck)
        } else {
            selectedDucks.add(duck)
        }
    }

    fun noSelectedDucks() = selectedDucks.isEmpty()

    fun getSelectedDucks(): MutableList<Duck> {
        val result = mutableListOf<Duck>()
        //val result: MutableList<Duck> = ArrayList()
        for (selectedDuck in selectedDucks) {
            result.add(selectedDuck)
        }
        return result
    }

    companion object {
        private const val MAX_DUCKS = 8
    }
}

