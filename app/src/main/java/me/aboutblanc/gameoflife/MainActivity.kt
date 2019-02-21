package me.aboutblanc.gameoflife

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {
    private val cps = 2
    private lateinit var game : Game

    private var loopTimer : Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener { onButtonClicked() }
    }

    override fun onResume() {
        super.onResume()

        setup()

        loopTimer = fixedRateTimer(initialDelay = 500, period = (1000/cps).toLong()) {
            runOnUiThread { loop() }
        }
    }

    override fun onPause() {
        super.onPause()
        loopTimer?.cancel()
    }

    //Roda uma vez ao iniciar a activity
    private fun setup() {
        game = Game(10,10)
    }

    //Roda cps vezes por segundo
    private fun loop() {
        game.nextGeneration()

        boardView.setBoard(game.getBoard())
    }

    private fun onButtonClicked() {
        game.clearBoard()
        game.makeCellAlive(0,0)
        boardView.setBoard(game.getBoard())
    }
}
