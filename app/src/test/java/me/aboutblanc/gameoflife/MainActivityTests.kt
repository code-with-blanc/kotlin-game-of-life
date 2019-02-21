package me.aboutblanc.gameoflife

import org.junit.Test

class MainActivityTests {
    @Test
    fun iniciaVazio() {
        val game = Game(10,10)

        assert(!game.getBoard().asArray().contains(Game.ALIVE))
    }
}
