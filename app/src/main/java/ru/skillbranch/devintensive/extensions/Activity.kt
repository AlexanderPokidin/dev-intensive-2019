package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlin.math.roundToLong

fun Activity.hideKeyboard() {
    val inputMethodManager: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    val view: View? = this.currentFocus
    if (view != null) {
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Activity.isKeyboardOpen(): Boolean {
    val rootView = findViewById<View>(R.id.content)
    val visibleBorders = Rect()
    rootView.getWindowVisibleDisplayFrame(visibleBorders)
    val heightDifference = rootView.height - visibleBorders.height()

    return heightDifference > dpToPx(100F, this)
}

fun Activity.isKeyboardClosed(): Boolean {
    return !this.isKeyboardOpen()
}

fun dpToPx(dp: Float, context: Context): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics).toInt()
}