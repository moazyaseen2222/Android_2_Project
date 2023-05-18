package com.example.android_2_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.load
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val imageURL =
            "https://www.mnp.ca/-/media/foundation/integrations/personnel/2020/12/16/13/57/personnel-image-4483.jpg?h=800&w=600&hash=9D5E5FCBEE00EB562DCD8AC8FDA8433D"
        iv_person_image.load(imageURL) {
            crossfade(true)
            placeholder(R.drawable.image)
            error(R.drawable.image)

        }
        val userDocRef = FirebaseFirestore.getInstance().collection("users")
            .document(FirebaseAuth.getInstance().currentUser?.uid!!)

        userDocRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val user = document.toObject(User::class.java)
                    if (user != null) {
                        tvUserName.text = "  🙍‍ Name :  ${user.name}"
                        tvEmail.text = "  📧 Email :  ${user.email}"
                        tvPassword.text = "  🔐 Password :  ${user.password}"
                        tvAddress.text = "  🎯 Address :  ${user.address}"
                        tvDob.text = "  📆 Date of Birth :  ${user.dob}"
                    }
                    // Display the user's information in the profile screen
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Unavailable data!", Toast.LENGTH_SHORT)
                    .show()
            }

        btn_update_data.setOnClickListener {
            val intent = Intent(this, UpdateProfile::class.java)
            startActivity(intent)
        }

    }
}