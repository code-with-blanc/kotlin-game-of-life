package me.aboutblanc.gameoflife

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {
    private var board = BoolMatrix(20, 20)
    private val cps = 2

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
        board[0][0] = true

        boardView.setBoard(board)
    }

    //Roda cps vezes por segundo
    private fun loop() {
        val nextBoard = BoolMatrix(board.m(), board.n())

        for (i in 0 until board.m()) {
            for (j in 0 until board.n()) {
                if(i >= 1) {
                    if(board[i-1][j]) {
                        nextBoard[i][j] = true
                    }
                }
            }
        }

        board = nextBoard
        boardView.setBoard(nextBoard)
    }

    private fun onButtonClicked() {
        board[0][0] = true
        boardView.setBoard(board)
    }
}
