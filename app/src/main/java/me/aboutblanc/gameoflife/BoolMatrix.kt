package me.aboutblanc.gameoflife

//Implementa uma matriz de booleanos
//
//      //cria matriz 3x3, elementos inicializados como false
//      let a = BoolMatrix(3,3)
//      //altera um elemento
//      a[0][1] = true
//
class BoolMatrix() {
    private var mat = arrayOf(arrayOf<Boolean>())

    constructor(m : Int, n : Int) : this() {
        mat = Array(m) { Array(n) { false } }
    }

    operator fun get(i : Int, j : Int) : Boolean {
        return mat[i][j]
    }

    operator fun set(i : Int, j : Int, value : Boolean) {
        mat[i][j] = value
    }

    operator fun get(i : Int) : Array<Boolean> {
        return mat[i]
    }

    fun size() : Pair<Int, Int> {
        return Pair(mat.size, mat[0].size)
    }

    fun m() : Int = size().first
    fun n() : Int = size().second
}