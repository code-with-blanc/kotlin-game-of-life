package me.aboutblanc.gameoflife

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.ImageView

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
                canvas?.drawColor(Color.WHITE)

                val dx = width/m
                val dy = height/n

                paint.color = Color.BLACK
                for (i in 0 until m) {
                    for (j in 0 until n) {
                        val alive = board?.get(i,j) ?: false
                        if(alive) {
                            rect.set(i*dx, j*dy, (i+1)*dx, (j+1)*dy)
                            canvas?.drawRect(rect, paint)
                        }

                    }
                }
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