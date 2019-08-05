package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager
import ru.skillbranch.devintensive.utils.Utils

fun Activity.hideKeyboard() {
    val inputMethodManager: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    val view: View? = this.currentFocus
    if (view != null) {
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Activity.isKeyboardOpen(): Boolean {
    val rootView = findViewById<View>(android.R.id.content)
    val visibleBorders = Rect()
    rootView.getWindowVisibleDisplayFrame(visibleBorders)
    val heightDifference = rootView.height - visibleBorders.height()

    return heightDifference > Utils.dpToPx(100F, this)
}

fun Activity.isKeyboardClosed(): Boolean {
    return !this.isKeyboardOpen()
}
