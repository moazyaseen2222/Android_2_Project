package com.example.android_2_project

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore

import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setTitle("SIGN UP")
        var date = ""
        // var userType = ""





        dob_field.setOnClickListener {
            val datePickerButton = findViewById<Button>(R.id.dob_field)
            datePickerButton.setOnClickListener {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                val datePickerDialog = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        // Do something with the date chosen by the user
                        // User(dob = dob_field.text.toString())
                        date = "${dayOfMonth}/${monthOfYear}/${year}"
                    }, year, month, day
                )

                datePickerDialog.show()
            }

        }
//        submitUserType.setOnClickListener {
//
//            print("User Type: $userType ******************************************")
//            val radioGroup = findViewById<RadioGroup>(R.id.my_radio_group)
//
//            radioGroup.setOnCheckedChangeListener { group, checkedId ->
//                val selectedRadioButton = findViewById<RadioButton>(checkedId)
//                val radioButtonValue = selectedRadioButton.text.toString()
//                userType = radioButtonValue
//                print("User Type : $radioButtonValue ******************************************")
//
//                Toast.makeText(this, "Selected Radio Button is: $radioButtonValue", Toast.LENGTH_SHORT).show()
//            }
//
//            print("User Type: $userType ******************************************")
//        }
        ///



        /// Radio
        //val radioGroup = findViewById<RadioGroup>(R.id.my_radio_group)
//        val theUser = findViewById<RadioButton>(R.id.radio_user)
//        val theAdmin = findViewById<RadioButton>(R.id.radio_admin)
//
//        radioGroup.setOnCheckedChangeListener { group, checkedId ->
//            when (checkedId) {
//                R.id.radio_user -> {
//                    userType =  "User"
//                }
//                R.id.radio_admin -> {
//                    userType = "Admin"
//                }
//            }
//        }


        ///

        sign_up_button.setOnClickListener {
            if (email_field.text.isNotEmpty() && password_field.text.isNotEmpty()) {
                val auth = Firebase.auth
                val email = email_field.text.toString()
                val password = password_field.text.toString()
                val location = location_field.text.toString()
                val dob = dob_field.text.toString()
                /////

                //////
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Register success!", Toast.LENGTH_SHORT).show()

                            ///
                            val user = User(
                                uid = FirebaseAuth.getInstance().currentUser?.uid,
                                name = username_field.text.toString(),
                                email = FirebaseAuth.getInstance().currentUser?.email,
                                password = password_field.text.toString(),
                                address = location_field.text.toString(),
                                // dob = dob_field.text.toString()
                                dob = date,
                           //     userType = userType


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
                            val intent = Intent(this, Selection::class.java)
                            startActivity(intent)
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