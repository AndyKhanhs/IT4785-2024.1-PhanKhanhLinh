package com.example.gmail

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CustomAvatar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {

    private var circleColor = Color.parseColor("#6200EE") // Default circle color
    private var textColor = Color.WHITE // Text color
    private var text: String? = null // Text to draw

    // Paint objects for drawing
    private val circlePaint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.FILL
        color = circleColor
    }

    private val textPaint = Paint().apply {
        isAntiAlias = true
        color = textColor
        textSize = 50f // Text size
        textAlign = Paint.Align.CENTER // Center the text
    }

    // Method to set the text and color
    fun setText(character: String, color: String) {
        text = character
        circleColor = Color.parseColor(color)
        circlePaint.color = circleColor
        invalidate() // Request a redraw
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw the circle
        val radius = width / 2f
        canvas.drawCircle(radius, radius, radius, circlePaint)

        // Draw the text
        text?.let {
            val x = width / 2f
            val y = height / 2f - (textPaint.descent() + textPaint.ascent()) / 2 // Centering the text vertically
            canvas.drawText(it, x, y, textPaint)
        }
    }
}