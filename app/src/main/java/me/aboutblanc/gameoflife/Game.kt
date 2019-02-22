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

    fun countNeighbor(i: Int, j: Int) : Int{
        var cont = 0
        var i1 = i-1
        var i2 = i+1
        var j1 = j-1
        var j2 = j+1

        if (i == 0)
            i1 = 0
        if (j == 0)
            j1 = 0
        if (i == board.m()-1)
            i2 = board.m()-1
        if (j == board.n()-1)
            j2 = board.n()-1

        for(x in i1..i2){
            for(y in j1..j2 ){
                if (x!=i && y!=j && board[x][y] == ALIVE) {
                    cont += 1
                }
            }
        }
        return cont
    }

    fun nextGeneration() {
        var cont = 0
        //var matriz[i][j]
        //criar matriz auxiliar ?
        for(i in 1 until board.m()) {
            for(j in 1 until board.n()) {
                if(board[i][j] == ALIVE)
                {//Regra 1

                    if(cont < 3){
                        board[i][j] = DEAD
                    }
                    cont = 0
                }
            }
        }
    }

    fun makeCellAlive(i: Int, j: Int) {
        board[i][j] = ALIVE
    }
}