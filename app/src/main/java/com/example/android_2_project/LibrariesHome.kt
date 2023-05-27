package com.example.android_2_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore

class LibrariesHome : AppCompatActivity() {
    override fun onBackPressed() {
        val intent = Intent(this, Admin::class.java)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libraries_home)
        setTitle("Libraries")


        val query = FirebaseFirestore.getInstance().collection("libraries")
        val options = FirestoreRecyclerOptions.Builder<Library>()
            .setQuery(query, Library::class.java)
            .build()
        val adapter = MyAdapter(options)
        val recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
}


/// Adapter

class MyAdapter(options: FirestoreRecyclerOptions<Library>) :
    FirestoreRecyclerAdapter<Library, MyAdapter.MyViewHolder>(options) {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.library_list_item)
        fun bind(data: Library) {
            textView.text = data.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_libraries_home, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: Library) {
        holder.bind(model)
    }
}
