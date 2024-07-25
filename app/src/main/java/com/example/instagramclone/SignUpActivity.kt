package com.example.instagramclone

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.instagramclone.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    val binding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signUpBtn.setOnClickListener {
            if (binding.name.editText?.text.toString().equals("") or
                binding.email.editText?.text.toString().equals("") or
                binding.password.editText?.text.toString().equals("")
            ) {
                Toast.makeText(
                    this@SignUpActivity,
                    "please fill all the information",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.email.editText?.text.toString(),
                    binding.password.editText?.text.toString()
                ).addOnCompleteListener { result ->
                    if (result.isSuccessful) {
                        Toast.makeText(
                            this@SignUpActivity,
                            "Account Created Successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    } else {
                        Toast.makeText(
                            this@SignUpActivity,
                            result.exception?.localizedMessage,
                            Toast.LENGTH_SHORT
                        ).show()
                    }


                }
            }
        }
    }
}

