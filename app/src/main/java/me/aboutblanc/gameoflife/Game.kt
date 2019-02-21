package me.aboutblanc.gameoflife

class Game(val m : Int, val n : Int) {
    private var board = BoolMatrix(m,n)

    companion object {
        val ALIVE = true
        val DEAD = false
    }

    fun getBoard() : BoolMatrix {
        return board
    }

    fun clearBoard() {
        board = BoolMatrix(m, n)
    }

    fun nextGeneration() {

    }

    fun makeCellAlive(i: Int, j: Int) {
        board[i][j] = ALIVE
    }
}