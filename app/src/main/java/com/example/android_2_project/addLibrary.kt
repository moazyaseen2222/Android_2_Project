package com.example.android_2_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import coil.load
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_book.*
import kotlinx.android.synthetic.main.activity_add_library.*

class addLibrary : AppCompatActivity() {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_library)
        setTitle("Add New Library")

        lateinit var etName: EditText
        lateinit var address: EditText
        lateinit var booksNumber: EditText
        lateinit var etRate: EditText
        lateinit var btnAddImage: Button
        lateinit var btnAddLibrary: Button
        lateinit var imageView: ImageView


        etName = findViewById(R.id.library_name)
        address = findViewById(R.id.library_address)
        booksNumber = findViewById(R.id.library_booksNumber)
        etRate = findViewById(R.id.library_rate)
        btnAddImage = findViewById(R.id.btn_add_image)
        btnAddLibrary = findViewById(R.id.btn_add_book)
        imageView = findViewById(R.id.iv_library_image)


        btnAddImage.setOnClickListener {
            val imageURL =
                "https://th.bing.com/th/id/R.647f586179ffb9864a3e85fbcb4b42c5?rik=7OqXE%2fWErbqz5Q&pid=ImgRaw&r=0"

            iv_library_image.load(imageURL) {
                crossfade(true)
                placeholder(R.drawable.image)
                error(R.drawable.image)

            }


            btnAddLibrary.setOnClickListener {
                val name = etName.text.toString()
                val address = address.text.toString()
                val booksNumber = booksNumber.text.toString()
                val rate = etRate.text.toString()
                val imageURL =
                    "https://th.bing.com/th/id/R.647f586179ffb9864a3e85fbcb4b42c5?rik=7OqXE%2fWErbqz5Q&pid=ImgRaw&r=0"

                val library = Library(name, address, "$booksNumber book", "$rate ⭐", imageURL)

                if (name.isEmpty() || address.isEmpty() || booksNumber.isEmpty() || rate.isEmpty()/* || imageUri == null*/) {
                    Toast.makeText(applicationContext, "Please fill all fields", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    db.collection("libraries")
                        .add(library)
                        .addOnSuccessListener {
                            Toast.makeText(
                                applicationContext,
                                "Library added successfully",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            val intent = Intent(this, LibrariesHome::class.java)
                            startActivity(intent)
                        }
                        .addOnFailureListener {
                            Toast.makeText(
                                applicationContext,
                                "Failed to add Library!",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }


                }
            }
        }
    }
}
