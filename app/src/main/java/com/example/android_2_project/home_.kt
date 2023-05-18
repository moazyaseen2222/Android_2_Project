package com.example.android_2_project

import BookAdapter
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_home2.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.list_items.*

class home_ : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<BookAdapter.ViewHolder>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        setTitle("Home")

        val db = Firebase.firestore
        val booksCollectionRef = db.collection("books")

        booksCollectionRef.get().addOnSuccessListener { documents ->
            val booksList = mutableListOf<Book>()
            for (document in documents) {
                val book = document.toObject(Book::class.java)
                booksList.add(book)
            }

            for (item in booksList) {
                titleTextView.setText(item.name)
                descriptionTextView.setText(item.description)
            }
            // Use the booksList to populate your UI or perform other actions
        }.addOnFailureListener { exception ->
            Log.d("TAG", "Error getting documents: $exception")
        }



























//        val collectionRef = Firebase.firestore.collection("books")
//        val documentList = mutableListOf<DocumentSnapshot>()
//
//        collectionRef.get()
//            .addOnSuccessListener { querySnapshot ->
//
//                for (document in querySnapshot.documents) {
//                    documentList.add(document)
//                    val myObject = document.toObject(Book::class.java)
//                    val title = myObject?.name
//                    val description = myObject?.description
//                    val price = myObject?.price
//                    val image = myObject?.image
//
//                    titleTextView.text = "Title : $title"
//                    descriptionTextView.text = "Description : $description"
//                    priceView.text = "Price : $price $"
//                  //  imageView.load(image)
//
//
//                }
//
//                // Use the documentList here
//            }
//            .addOnFailureListener { exception ->
//                // Handle any errors
//            }


//        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
//        progressBar.visibility = View.VISIBLE // show the progress bar
        //val data = ArrayList<Book>()

//        val db = FirebaseFirestore.getInstance()
//
//        db.collection("books")
//            .get()
//            .addOnSuccessListener { result ->
//                //val book = document.toObject(Book::class.java)
//                //  progressBar.visibility = View.GONE // hide the progress bar
//                for (document in result) {
//
//                    data.add(
//                        Book(
//                            "${document.get("name")}",
//                            "${document.get("description")}",
//                            "${document.get("price")}",
//                            "${document.get("rate")}",
//                            "${document.get("image")}"
//                        )
//                    )
//                    val name = document.get("name")
//                    val description = document.get("description")
//                    val price = document.get("price")
//                    titleTextView.text = "Title : ${name as CharSequence?}"
//                    descriptionTextView.text = "Description : ${description as CharSequence?}"
                    //  priceView.text = "Price : ${price as CharSequence?} $"
//                    print("*****************/*/*/*/*/*/*/*/**************************************")
//                    print("${data[0]}")
//                    print("*****************/*/*/*/*/*/*/*/**************************************")
//
//
//                }
//            }
//            .addOnFailureListener { exception ->
//                // progressBar.visibility = View.GONE // hide the progress bar
//                Toast.makeText(this, "Can not Show Books,Check Internet...", Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//
//        recyclerViewNew.layoutManager = LinearLayoutManager(this)
//        val bookAdapter = BookAdapter(data)
//        recyclerViewNew.adapter = bookAdapter


//
//        val documents = mutableListOf<Book>()
//        val adapter = MyAdapter(documents)
//        recyclerView.adapter = adapter

//        db.collection("books")
//            .get()
//            .addOnSuccessListener { result ->
//                documents.clear()
//                for (document in result) {
//                    val myDocument = document.toObject<Book>()
//                    documents.add(myDocument)
//                }
//                adapter.notifyDataSetChanged()
//            }
//            .addOnFailureListener { exception ->
//                Log.d("TAG", "Error getting documents: ", exception)
//            }

//        val documents = mutableListOf<Book>()
//        layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = layoutManager
//        adapter = MyAdapter(documents)
//        recyclerView.adapter = adapter
    }
}