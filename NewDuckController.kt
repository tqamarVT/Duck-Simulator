package ducksim

class NewDuckController(private val duckPond: DuckPond, private val view: DuckSimView) {

    fun createNewDuck() {
        var duckList = mutableListOf<Duck>()
        if (duckPond.noSelectedDucks()) {
            val makeDuckDialog = MakeDuckDialog(duckPond, view)
            makeDuckDialog.setSize(300, 200)
            makeDuckDialog.isVisible = true
        } else {
            // get the selected ducks from the model
            duckList = duckPond.getSelectedDucks()
            // filter the selected ducks by removing any flocks
            duckList.removeAll { it is Flock }
        }
        // if there is more than one duck after removing flocks,
        // create a new flock with the selected ducks
        if (duckList.size > 1) {
            val flock = Flock(duckList)
            duckPond.addNewDuck(flock)
        }
        view.repaint()
    }
}

