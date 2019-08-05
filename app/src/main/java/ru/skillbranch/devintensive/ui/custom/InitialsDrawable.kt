package ru.skillbranch.devintensive.ui.custom

import android.graphics.*
import android.graphics.drawable.Drawable

class InitialsDrawable : Drawable() {

    var initials: String = ""
    var textColor = Color.WHITE
    var backgroundColor = Color.BLACK

    var paint = Paint().apply {
        isAntiAlias = true
        isFakeBoldText = true
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
    }

    override fun draw(canvas: Canvas) {
        if (initials.isBlank()) {
            return
        }
        canvas.drawRect(bounds, paint.apply { color = backgroundColor })

        paint.textSize = bounds.width() * 0.5F
        val xPosition = bounds.width() / 2F
        val yPosition = (bounds.height() / 2F - (paint.descent() + paint.ascent()) / 2)

        canvas.drawText(initials, xPosition, yPosition, paint.apply { color = textColor })
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }
}