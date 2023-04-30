package com.example.android_2_project

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.io.IOException


class add_book : AppCompatActivity() {
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

        val PICK_IMAGE_REQUEST = 1
        var imageUri: Uri? = null

        etName = findViewById(R.id.et_book_name)
        etDescription = findViewById(R.id.et_book_description)
        etPrice = findViewById(R.id.et_book_price)
        etRate = findViewById(R.id.et_book_rate)
        btnAddImage = findViewById(R.id.btn_add_image)
        btnAddBook = findViewById(R.id.btn_add_book)
        imageView = findViewById(R.id.iv_book_image)

        btnAddImage.setOnClickListener {
          //  openFileChooser()
        }


        btnAddBook.setOnClickListener {
            val name = etName.text.toString().trim()
            val description = etDescription.text.toString().trim()
            val price = etPrice.text.toString().trim().toBigDecimalOrNull()
            val rate = etRate.text.toString().trim().toIntOrNull()

            if (name.isEmpty() || description.isEmpty() || price == null || rate == null || imageUri == null) {
                Toast.makeText(applicationContext, "Please fill all fields", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // TODO: add book to database or network

                Toast.makeText(applicationContext, "Book added successfully", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

//    private fun openFileChooser() {
//        val intent = Intent()
//        intent.type = "image/*"
//        intent.action = Intent.ACTION_GET_CONTENT
//        startActivityForResult(intent, PICK_IMAGE_REQUEST)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
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

}
