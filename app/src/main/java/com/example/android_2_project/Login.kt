package com.example.android_2_project


import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
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


                            ////
                            val userDocRef = FirebaseFirestore.getInstance().collection("users")
                                .document(FirebaseAuth.getInstance().currentUser?.uid!!)

                            userDocRef.get()
                                .addOnSuccessListener { document ->
                                    if (document != null && document.exists()) {
                                        val user = document.toObject(User::class.java)
                                        if (user != null) {
                                            if(user.userType == "Admin"){
                                                val intent = Intent(this, Admin::class.java)
                                                startActivity(intent)
                                            }else{
                                                val intent = Intent(this, UserSystem::class.java)
                                                startActivity(intent)
                                            }
                                        }
                                        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .addOnFailureListener { exception ->
                                    Toast.makeText(this, "Unavailable user!", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            ////



                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                                if (getBaseContext().checkSelfPermission("android.permission.READ_DEVICE_CONFIG") == PackageManager.PERMISSION_GRANTED) {
                                    // The app has permission to read system properties
                                    print("************************************* OK NO ERROR *******************************")
                                } else {
                                    // The app does not have permission to read system properties
                                    print("*************************************  ERROR *******************************")
                                }
                            }

                        } else {
                            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, Login::class.java)
                            startActivity(intent)
                        }
                    }
            } else if (email_field.text.isEmpty() && password_field.text.isEmpty()) {
                Toast.makeText(this, "fill all fields!", Toast.LENGTH_SHORT).show()
            }


        }
    }
}