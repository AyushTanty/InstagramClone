package com.example.instagramclone

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.instagramclone.Models.User
import com.example.instagramclone.databinding.ActivityLoginBinding
import com.google.firebase.Firebase

class LoginActivity : AppCompatActivity() {
    private  val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.loginBtn.setOnClickListener {
  if(binding.email.editText?.text.toString().equals("") or
      binding.pass.editText?.text.toString().equals("")  ){
      Toast.makeText(this@LoginActivity,
          "Please fil all details",
          Toast.LENGTH_SHORT
      ).show()
  }else{
      var user=User(binding.email.editText?.text.toString(),
          binding.pass.editText?.text.toString())

      Firebase.auth.signInWithEmailAndPassword(user.email!!,user.password!!)
      if(it.issuccessful){
          startActivity(Intent(this@LoginActivity,HomeActivity::class.java))
          finish()
      }else{
          Toast.makeText(this@LoginActivity,
              it.exception?.localizedMessage,
              Toast.LENGTH_SHORT
          ).show()
      }
  }
        }
        }
    }
