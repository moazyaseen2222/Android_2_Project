package com.example.android_2_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore

import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setTitle("SIGN UP")

        sign_up_button.setOnClickListener {
            if (email_field.text.isNotEmpty() && password_field.text.isNotEmpty()) {
                val auth = Firebase.auth
                val email = email_field.text.toString()
                val password = password_field.text.toString()
                val location = location_field.text.toString()
                val dob = dob_field.text.toString()
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Register success!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, Selection::class.java)
                            startActivity(intent)
                            ///
                            val user = User(
                                uid = FirebaseAuth.getInstance().currentUser?.uid,
                                name = username_field.text.toString(),
                                email = FirebaseAuth.getInstance().currentUser?.email,
                                password = password_field.text.toString(),
                                address = location_field.text.toString(),
                                dob = dob_field.text.toString()


                            )
                            FirebaseFirestore.getInstance().collection("users")
                                .document(user.uid!!)
                                .set(user)
                                .addOnSuccessListener {
                                    Toast.makeText(
                                        this,
                                        "User info saved successfully",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                .addOnFailureListener { e ->
                                    Toast.makeText(
                                        this,
                                        "Failed to  save user info ",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            ///
                        } else {
                            Toast.makeText(this, "Registration failed!", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this, SignUp::class.java)
                            startActivity(intent)
                        }
                    }
            } else if (email_field.text.isEmpty() && password_field.text.isEmpty()) {
                Toast.makeText(this, "fill all fields!", Toast.LENGTH_SHORT).show()
            }


        }
    }
}