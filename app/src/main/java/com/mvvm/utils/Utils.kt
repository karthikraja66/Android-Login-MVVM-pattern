package com.mvvm.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.util.regex.Matcher
import java.util.regex.Pattern

object Utils {
    fun isValidEmail(emailStr: String?): Boolean {
        val pattern = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE
        )
        val matcher: Matcher = pattern.matcher(emailStr)
        return matcher.find()
    }

    fun showKeyboard(editText: EditText, context: Context) {
        editText.requestFocus()
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInputFromWindow(
            editText.windowToken,
            InputMethodManager.SHOW_FORCED,
            0
        )
    }

    fun hideSoftKeyboard(activity: Activity?) {
        if (activity != null) {
            try {
                val inputMethodManager =
                    activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(
                    activity.currentFocus!!.windowToken,
                    0
                )
            } catch (e: Exception) {
            }
        }
    }
}
