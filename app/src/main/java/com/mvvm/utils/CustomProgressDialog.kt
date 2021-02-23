package com.mvvm.utils

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.mvvm.databinding.CustomProgressLayoutBinding

class CustomProgressDialog(private val activity: Activity) : AlertDialog(activity) {
    private lateinit var binding: CustomProgressLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        binding = CustomProgressLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(this.window?.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.MATCH_PARENT
        lp.gravity = Gravity.CENTER
        this.window?.attributes = lp
    }

    fun hideProgressDialog() {
        if (isShowing && !activity.isFinishing) dismiss()
    }
}