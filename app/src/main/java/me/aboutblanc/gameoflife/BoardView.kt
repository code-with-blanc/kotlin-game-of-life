package me.aboutblanc.cyberpunktv

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ImageView
import me.aboutblanc.gameoflife.BoolMatrix

// Essa view é usada para visualizar um tabuleiro (board) do jogo da vida
//
// O estado atual do jogo, representado por uma matriz de booleanos (true, false)
// é passado através da função setBoard(board)

class BoardView(context : Context, attrs: AttributeSet) : ImageView(context, attrs) {
    private var board : BoolMatrix? = null

    // Public functions
    fun setBoard(board : BoolMatrix?) {
        this.board = board
        invalidate()
    }

    //allocated for onDraw
    private val paint = Paint()
    private val rect = Rect()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val m = board?.m() ?: 0
        val n = board?.n() ?: 0
        if(board != null && m > 0 && n > 0) {
            board?.let {
                val dx = width/m
                val dy = height/n

                //TODO: draw
            }
        } else {
            canvas?.drawPaint(paint)
            canvas?.drawColor(Color.WHITE)
            paint.color = Color.BLACK
            paint.textSize = 40f
            paint.textAlign = Paint.Align.CENTER
            canvas?.drawText("Board not provided", (width/2).toFloat(), (height/2).toFloat(), paint)
        }
    }
}