package com.example.android_2_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_home2.*

class MyBooks : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<BookAdapter.ViewHolder>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_books)
        setTitle("My Books")

        val db = Firebase.firestore
        var dataList = listOf<DocumentSnapshot>()

        db.collection("books").get().addOnSuccessListener { documents ->
            dataList = documents.documents
        }

        val adapter = ArrayAdapter<DocumentSnapshot>(this, android.R.layout.activity_list_item, dataList)
        list_view.adapter = adapter
    }
}