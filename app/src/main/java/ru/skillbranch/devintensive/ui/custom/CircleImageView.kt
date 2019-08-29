package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.Dimension
import ru.skillbranch.devintensive.R
import ru.skillbranch.devintensive.utils.Utils
import kotlin.math.min
import kotlin.math.roundToInt

open class CircleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    companion object {
        private const val DEFAULT_BORDER_COLOR = Color.WHITE
        private const val DEFAULT_BORDER_WIDTH_DP = 2F
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val clipPath = Path()

    private var borderColor = DEFAULT_BORDER_COLOR
    private var borderWidth = Utils.dpToPx(DEFAULT_BORDER_WIDTH_DP, context)

    init {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
            borderColor = a.getColor(R.styleable.CircleImageView_cv_borderColor, DEFAULT_BORDER_COLOR)
            borderWidth = a.getDimension(R.styleable.CircleImageView_cv_borderWidth, borderWidth)
            a.recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        val x = width / 2F
        val y = height / 2F
        val radius = min(x, y)

        clipPath.addCircle(x, y, radius, Path.Direction.CW)
        canvas?.clipPath(clipPath)

        super.onDraw(canvas)

        drawCircle(canvas, x, y, radius)
    }

    private fun drawCircle(canvas: Canvas?, x: Float, y: Float, radius: Float) {
        paint.style = Paint.Style.STROKE
        paint.color = borderColor
        paint.strokeWidth = borderWidth

        canvas?.drawCircle(x, y, radius, paint)
    }

    @Dimension
    fun getBorderWidth(): Int {
        return Utils.pxToDp(borderWidth, context).roundToInt()
    }

    fun setBorderWidth(@Dimension dp: Int) {
        borderWidth = Utils.dpToPx(dp.toFloat(), context)
        invalidate()
    }

    fun getBorderColor(): Int {
        return borderColor
    }

    fun setBorderColor(hex: String) {
        borderColor = Color.parseColor(hex)
        invalidate()
    }

    fun setBorderColor(@ColorRes colorId: Int) {
        borderColor = resources.getColor(colorId, context.theme)
        invalidate()
    }
}
