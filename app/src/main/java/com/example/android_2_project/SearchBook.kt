package com.example.android_2_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SearchBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_book)
        setTitle("البحث")
    }
}