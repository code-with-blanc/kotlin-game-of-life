package me.aboutblanc.gameoflife

import org.junit.Before
import org.junit.Test

class MainActivityTests {
    private lateinit var game : Game

    @Before fun setup() {
        game = Game(10,10)
    }

    @Test
    fun iniciaVazio() {
        assert(numberOfLivingCells() == 0)
    }

    @Test fun limpaTabuleiro() {
        game.makeCellAlive(1,1)
        assert(numberOfLivingCells() == 1)
        game.clearBoard()
        assert(numberOfLivingCells() == 0)
    }

    @Test fun regra1() {
        //Any live cell with fewer than two live neighbours dies, as if caused by under-population.
        game.makeCellAlive(1,1)
        assert(numberOfLivingCells() == 1)
        game.nextGeneration()
        assert(numberOfLivingCells() == 0)
    }

    @Test fun regra2_2vizinhos() {
        //Any live cell with two or three live neighbours lives on to the next generation.
        game.makeCellAlive(1,1)
        game.makeCellAlive(2,2)
        game.makeCellAlive(3,3)
        game.nextGeneration()
        assert(game.getBoard()[2][2] == Game.ALIVE)
    }

    @Test fun regra2_3vizinhos() {
        //Any live cell with two or three live neighbours lives on to the next generation.
        game.makeCellAlive(1,1)
        game.makeCellAlive(2,2)
        game.makeCellAlive(3,3)
        game.makeCellAlive(1,3)
        game.nextGeneration()
        assert(game.getBoard()[2][2] == Game.ALIVE)
    }

    @Test fun regra3() {
        //Any live cell with more than three live neighbours dies, as if by overcrowding.
        game.makeCellAlive(0,0)
        game.makeCellAlive(0,2)
        game.makeCellAlive(2,0)
        game.makeCellAlive(0,0)

        game.makeCellAlive(1,1)

        game.nextGeneration()
        assert(game.getBoard()[1][1] == Game.DEAD)
    }

    @Test fun regra4() {
        //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
        game.makeCellAlive(0,0)
        game.makeCellAlive(0,2)
        game.makeCellAlive(2,0)

        game.nextGeneration()
        assert(game.getBoard()[1][1] == Game.ALIVE)
    }

    private fun numberOfLivingCells() : Int {
        return game.getBoard().asArray().count { it -> it == Game.ALIVE }
    }
}
