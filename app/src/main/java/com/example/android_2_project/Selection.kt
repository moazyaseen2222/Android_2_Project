package com.example.android_2_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_selection.*
import kotlinx.android.synthetic.main.activity_user_system.*

class Selection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
        setTitle("Who you are?")

        admin.setOnClickListener {
            val intent = Intent(this, Admin::class.java)
            startActivity(intent)
        }

        user.setOnClickListener {
            val intent = Intent(this, UserSystem::class.java)
            startActivity(intent)
        }
    }
}