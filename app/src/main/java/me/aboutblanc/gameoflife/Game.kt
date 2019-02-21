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
        for(i in 1 until board.m()) {
            for(j in 0 until board.n()) {
                if(board[i][j] == ALIVE) {
                    board[i][j] = DEAD
                    board[i-1][j] = ALIVE
                }
            }
        }
    }

    fun makeCellAlive(i: Int, j: Int) {
        board[i][j] = ALIVE
    }
}