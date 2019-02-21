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
    private var drawGridEnabled = true

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
        if(m > 0 && n > 0) {
            board?.let { board ->
                canvas?.drawColor(Color.WHITE)
                if(drawGridEnabled) {
                    drawGrid(canvas)
                }

                val dx = width/m
                val dy = height/n

                paint.color = Color.BLACK
                paint.style = Paint.Style.FILL
                for (i in 0 until m) {
                    for (j in 0 until n) {
                        val alive = board[i, j]
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

    private fun drawGrid(canvas : Canvas?) {
        paint.color = Color.GRAY
        paint.strokeWidth = 0f
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = false

        board?.let { board ->
            val m = board.m()
            val n = board.n()
            val dx = width/m
            val dy = width/n

            for(i in 0 .. m) {
                canvas?.drawLine(
                    (i*dx).toFloat(), 0f,
                    (i*dx).toFloat(), (m*dx).toFloat(),
                    paint )
            }

            for(j in 0 .. n) {
                canvas?.drawLine(
                    0f, (j*dy).toFloat(),
                    (n*dy).toFloat(), (j*dy).toFloat(),
                    paint )
            }
        }

    }
}