package com.mvvm.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mvvm.Authorization
import com.mvvm.MainActivity
import com.mvvm.R
import com.mvvm.databinding.ActivityLoginBinding
import com.mvvm.utils.CustomProgressDialog
import com.mvvm.utils.Utils
import com.mvvm.utils.disableStatusBar
import com.mvvm.utils.gradientStatusBar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val customProgressDialog: CustomProgressDialog by lazy {
        CustomProgressDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gradientStatusBar()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickLogin(view: View) {
        lifecycleScope.launch {
            customProgressDialog.show()
            delay(2000)
            if (validation()) {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
        }
    }

    private fun validation(): Boolean {
        customProgressDialog.hideProgressDialog()
        if (etLoginEmail.text.toString().trim().isEmpty()) {
            etLoginEmail.error = getString(R.string.please_enter_your_email)
            etLoginEmail.requestFocus()
            return false
        } else if (!Utils.isValidEmail(etLoginEmail.text.toString())) {
            etLoginEmail.error = getString(R.string.please_enter_a_valid_email)
            etLoginEmail.requestFocus()
            return false
        } else if (etLoginPassword.text.toString().trim().isEmpty()) {
            etLoginPassword.error = getString(R.string.please_enter_your_password)
            etLoginPassword.requestFocus()
            return false
        } else if (Authorization.values()
                .associateBy(Authorization::userName)[etLoginEmail.text.toString()] == null
        ) {
            etLoginEmail.error = getString(R.string.invalid_user)
            etLoginEmail.requestFocus()
            return false
        } else if (Authorization.values()
                .associateBy(Authorization::password)[etLoginPassword.text.toString()] == null
        ) {
            etLoginPassword.error = getString(R.string.incorrect_password)
            etLoginPassword.requestFocus()
            return false
        }
        return true
    }
}

