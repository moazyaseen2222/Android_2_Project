package com.example.android_2_project

import androidx.annotation.Keep

@Keep
data class Book(
    val name: String = "",
    val description: String = "",
    val price: String = "",
    val rate: String = "",
    val image: String = "",

    ) {
    constructor() : this("", "", "")
}
