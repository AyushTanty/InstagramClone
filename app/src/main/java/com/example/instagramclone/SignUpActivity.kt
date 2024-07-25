package com.example.instagramclone

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.instagramclone.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    val binding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signUpBtm.setOnClickListener {
            if (binding.name.editText?.text.toString().equals("") or
                binding.email.editText?.text.toString().equals("") or
                binding.password.editText?.text.toString().equals("")
            ) {
                Toast.makeText(this@SignUpActivity, "please fill all the information", Toast.LENGTH_SHORT).show()
            }else{

        }
        }
    }
}
val text = "<font color=#FF000000>Already have an Account</font> <font color=#1E88E5>Login ?</font>"
binding.login.setText(Html.fromHtml(text))