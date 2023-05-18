package com.example.android_2_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_admin.*
import kotlinx.android.synthetic.main.activity_map.*

class Admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        setTitle("Admin")

                   // اضافة مكتبة
        button.setOnClickListener {
            val intent = Intent(this, AddBook::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, AddBook::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this, AddBook::class.java)
            startActivity(intent)
        }
                       // ااضافة كتاب
        button4.setOnClickListener {
            val intent = Intent(this, AddBook::class.java)
            startActivity(intent)
        }

        button5.setOnClickListener {
            val intent = Intent(this, AddBook::class.java)
            startActivity(intent)
        }

        button6.setOnClickListener {
            val intent = Intent(this, AddBook::class.java)
            startActivity(intent)
        }

        button7.setOnClickListener {
            val intent = Intent(this, home_::class.java)
            startActivity(intent)
        }
                             //عرض الخريطة
        button8.setOnClickListener {
            val intent = Intent(this, Map_screen::class.java)
            startActivity(intent)
        }
                          // الصفحة الشخصية
        button14.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }



    }
}