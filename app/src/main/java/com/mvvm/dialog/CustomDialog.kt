package com.mvvm.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import com.mvvm.R
import com.mvvm.databinding.DialogCustomBinding

class CustomDialog(
    mContext: Context, private val contentText: String
) :
    Dialog(mContext) {
    private lateinit var binding: DialogCustomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.attributes?.windowAnimations = R.style.BottomSlideDialog
        binding = DialogCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCancelable(true)
        initView()
        setupListeners()
    }

    private fun initView() {
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(this.window?.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.CENTER
        this.window?.attributes = lp
        binding.contentText = contentText
    }

    private fun setupListeners() {
        binding.ivClose.setOnClickListener {
            dismiss()
        }
    }
}