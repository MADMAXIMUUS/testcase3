package ru.madmax.testcase3.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.show() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

inline fun View.showIf(condition: View.() -> Boolean) {
    if (condition()) {
        show()
    } else {
        hide()
    }
}

inline fun View.invisibleIf(condition: View.() -> Boolean) {
    if (condition()) {
        invisible()
    } else {
        show()
    }
}

inline fun View.hideIf(condition: View.() -> Boolean) {
    if (condition()) {
        hide()
    } else {
        show()
    }
}

fun Activity.hideKeyboard() {
    val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE)
            as InputMethodManager
    imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
}