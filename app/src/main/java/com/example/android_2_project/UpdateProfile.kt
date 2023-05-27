package com.example.android_2_project

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_update_profile.*
import java.util.*


class UpdateProfile : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)
        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection("users").document(FirebaseAuth.getInstance().currentUser?.uid!!)

        var date = "";

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
                        date = "${dayOfMonth}/${monthOfYear}/${year}"
                    }, year, month, day
                )

                datePickerDialog.show()
            }

        }

        update_button.setOnClickListener {
            docRef.update(mapOf(
                "address" to ulocation_field.text,
                "dob" to date,
                "name" to uusername_field.text,
                "password" to upassword_field.text,
            ))
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }



    }
}