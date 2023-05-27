package com.example.android_2_project

import androidx.annotation.Keep

@Keep
data class Library(
    val name: String = "",
    val address: String = "",
    val booksNumber: String = "",
    val rate: String = "",
    val image: String = "",

    ) {
    constructor() : this("", "", "")
}
