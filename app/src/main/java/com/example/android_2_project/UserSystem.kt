package com.example.android_2_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_admin.*
import kotlinx.android.synthetic.main.activity_user_system.*

class UserSystem : AppCompatActivity() {
    override fun onBackPressed() {
        finishAffinity()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_system)
        setTitle("الصفحة الرئيسية")




        button9.setOnClickListener {
            val intent = Intent(this, home_::class.java)
            startActivity(intent)
        }

        button10.setOnClickListener {
            val intent = Intent(this, MyBooks::class.java)
            startActivity(intent)
        }

        searchBook.setOnClickListener {
            val intent = Intent(this, SearchBook::class.java)
            startActivity(intent)
        }


        button13.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        button12.setOnClickListener {
            val intent = Intent(this, Map_screen::class.java)
            startActivity(intent)
        }

    }
}