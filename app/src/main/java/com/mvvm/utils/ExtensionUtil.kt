package com.mvvm.utils

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.mvvm.R
import com.mvvm.databinding.CustomToastBinding
import java.util.*

fun Activity.disableStatusBar() {
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    window.statusBarColor = Color.TRANSPARENT
}

fun Activity.gradientStatusBar() {
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.statusBarColor = Color.TRANSPARENT
    window.setBackgroundDrawableResource(android.R.color.white)
}
fun Activity.customToast(msg: String?) {
    Toast(this).apply {
        val binding = CustomToastBinding.inflate(this@customToast.layoutInflater)
        binding.tvToastMsg.text = msg
        duration = Toast.LENGTH_SHORT
        view = binding.root
        show()
    }
}