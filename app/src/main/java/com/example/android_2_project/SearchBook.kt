package com.example.android_2_project

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_search_book.*

class SearchBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_book)
        setTitle("Search book")

        searchButton.setOnClickListener {
            val db = FirebaseFirestore.getInstance()
            db.collection("books")
                .whereEqualTo("title", bookTitleSearch.text.toString()).whereEqualTo("price",bookPriceSearch.text.toString())
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        Toast.makeText(this,"The Book is Exist",Toast.LENGTH_SHORT).show()

                    }
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this,"The Book is Not Exist!",Toast.LENGTH_SHORT).show()

                }

        }
    }
}