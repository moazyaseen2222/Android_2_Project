package com.example.android_2_project

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_book.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException


class add_book : AppCompatActivity() {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val collectionRef = db.collection("books")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)


        lateinit var etName: EditText
        lateinit var etDescription: EditText
        lateinit var etPrice: EditText
        lateinit var etRate: EditText
        lateinit var btnAddImage: Button
        lateinit var btnAddBook: Button
        lateinit var imageView: ImageView



        etName = findViewById(R.id.et_book_name)
        etDescription = findViewById(R.id.et_book_description)
        etPrice = findViewById(R.id.et_book_price)
        etRate = findViewById(R.id.et_book_rate)
        btnAddImage = findViewById(R.id.btn_add_image)
        btnAddBook = findViewById(R.id.btn_add_book)
        imageView = findViewById(R.id.iv_book_image)

        btnAddImage.setOnClickListener {
            val imageURL =
                "https://www.englishexercises.org/exercisesmaker/uploads/images/1747201/book.jpg"

            iv_book_image.load(imageURL) {
                crossfade(true)
                placeholder(R.drawable.image)
                error(R.drawable.image)

            }


            btnAddBook.setOnClickListener {
                val name = etName.text.toString()
                val description = etDescription.text.toString()
                val price = etPrice.text.toString()
                val rate = etRate.text.toString()
                val imageURL =
                    "https://www.englishexercises.org/exercisesmaker/uploads/images/1747201/book.jpg"


                val data = hashMapOf(
                    "name" to name,
                    "description" to description,
                    "price" to "$price$",
                    "rate" to "$rate Stars",
                    "image" to imageURL,
                    "timestamp" to FieldValue.serverTimestamp()
                )

                if (name.isEmpty() || description.isEmpty() || price.isEmpty() || rate.isEmpty()/* || imageUri == null*/) {
                    Toast.makeText(applicationContext, "Please fill all fields", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    db.collection("books")
                        .add(data)
                        .addOnSuccessListener {
                            Toast.makeText(
                                applicationContext,
                                "Book added successfully",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            val intent = Intent(this, home::class.java)
                            startActivity(intent)
                        }
                        .addOnFailureListener {
                            Toast.makeText(
                                applicationContext,
                                "Failed to add book!",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }


                }
            }
        }

//    val PICK_IMAGE_REQUEST = 1
//    var imageUri: Uri? = null
//    private fun openFileChooser() {
//        val intent = Intent()
//        intent.type = "image/*"
//        intent.action = Intent.ACTION_GET_CONTENT
//        startActivityForResult(intent, PICK_IMAGE_REQUEST)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
//            imageUri = data.data
//            try {
//                val imageStream = contentResolver.openInputStream(imageUri!!)
//                val selectedImage = BitmapFactory.decodeStream(imageStream)
//                imageView.setImageBitmap(selectedImage)
//            } catch (e: IOException) {
//                e.printStackTrace()
//                Toast.makeText(applicationContext, "Failed to load image", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        }
//    }

    }}
