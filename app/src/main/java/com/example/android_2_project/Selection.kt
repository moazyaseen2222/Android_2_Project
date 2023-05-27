package com.example.android_2_project

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.android.synthetic.main.activity_selection.*
import kotlinx.android.synthetic.main.activity_user_system.*

class Selection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
        setTitle("Who you are?")
        val db = FirebaseFirestore.getInstance()


        val currentUser = FirebaseAuth.getInstance().currentUser
            val userId = currentUser?.uid

        val documentRef = db.collection("users").document(userId!!)


        admin.setOnClickListener {
            val newData: MutableMap<String, Any> = HashMap()
            newData["userType"] = "Admin"
            val options = SetOptions.merge()
            documentRef.set(newData, options)
                .addOnSuccessListener {
                    var data = newData.values
                    Toast.makeText(this,"Register as ${newData.values}",Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "DocumentSnapshot successfully updated!")
                    val intent = Intent(this, Admin::class.java)
                    startActivity(intent)

                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error updating document", e)
                }
        }

        user.setOnClickListener {
            val newData: MutableMap<String, Any> = HashMap()
            newData["userType"] = "User"
            val options = SetOptions.merge()
            documentRef.set(newData, options)
                .addOnSuccessListener {
                    Toast.makeText(this,"Register as $newData",Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "DocumentSnapshot successfully updated!")
                    val intent = Intent(this, UserSystem::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error updating document", e)
                }
        }

//        admin.setOnClickListener {
//            val  userType = "Admin"
//
//            val db = FirebaseFirestore.getInstance()
//            val user = hashMapOf(
//                "userType" to userType,
//            )
//
//            val currentUser = FirebaseAuth.getInstance().currentUser
//            val userId = currentUser?.uid
//
//
//            val userRef = db.collection("users").document(userId!!)
//            userRef.set(user)
//                .addOnSuccessListener {
//                    Log.d(TAG, "User data added successfully")
//                }
//                .addOnFailureListener {
//                    Log.e(TAG, "Error adding user data")
//                }
//
//            val intent = Intent(this, Admin::class.java)
//            startActivity(intent)
//
//        }
//
//        user.setOnClickListener {
//
//            val  userType2 = "User"
//
//            val db = FirebaseFirestore.getInstance()
//            val user = hashMapOf(
//                "userType" to userType2,
//            )
//
//            val currentUser = FirebaseAuth.getInstance().currentUser
//            val userId = currentUser?.uid
//
//
//            val userRef = db.collection("users").document(userId!!)
//            userRef.set(user)
//                .addOnSuccessListener {
//                    Log.d(TAG, "User data added successfully")
//                }
//                .addOnFailureListener {
//                    Log.e(TAG, "Error adding user data")
//                }
//
//            val intent = Intent(this, UserSystem::class.java)
//            startActivity(intent)
//        }
    }
}