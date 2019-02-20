package me.aboutblanc.gameoflife

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b = BoolMatrix(10, 10)
        b[0][0] = true
        b[1][1] = true
        b[2][2] = true
        b[3][9] = true

        boardView.setBoard(b)
    }
}
