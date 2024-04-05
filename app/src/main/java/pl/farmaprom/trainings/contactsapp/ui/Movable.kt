package pl.farmaprom.trainings.contactsapp.ui

interface Movable {
    var density: Double
    fun move()
}

class Box(val xyzWallsLength: Double) : Movable {
    override var density: Double = 1.90


    override fun move() {
        print(density)
    }

}