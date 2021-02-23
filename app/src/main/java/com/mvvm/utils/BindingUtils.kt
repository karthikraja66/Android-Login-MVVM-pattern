package com.mvvm.utils

import android.view.MotionEvent
import android.view.View
import androidx.databinding.BindingAdapter

object BindingUtils {
    @BindingAdapter("touchListener")
    @JvmStatic
    fun View.touchListener(value: Boolean?) {
        setOnTouchListener(object : View.OnTouchListener {
            var dX: Float = 0F
            var dY: Float = 0F
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        dX = this@touchListener.x - event.rawX
                        dY = this@touchListener.y - event.rawY
                    }
                    MotionEvent.ACTION_MOVE -> this@touchListener.animate()
                        .x(event.rawX + dX)
                        .y(event.rawY + dY)
                        .setDuration(0)
                        .start()
                    else -> return false
                }
                return true

            }
        })
    }
}