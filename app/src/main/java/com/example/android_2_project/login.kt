package com.example.android_2_project


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setTitle("LOGIN")
        sign_up_button.setOnClickListener {
            if (email_field.text.isNotEmpty() && password_field.text.isNotEmpty()) {
                val auth = Firebase.auth
                val email = email_field.text.toString()
                val password = password_field.text.toString()
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, login::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, login::class.java)
                            startActivity(intent)
                        }
                    }
            } else if (email_field.text.isEmpty() && password_field.text.isEmpty()) {
                Toast.makeText(this, "fill all fields!", Toast.LENGTH_SHORT).show()
            }


        }
    }
}