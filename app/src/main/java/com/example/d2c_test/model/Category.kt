package com.example.d2c_test.model

data class Category(
    val name: String,
    val image: Int
)
data class Product(
    val name: String,
    val description: String,
    val price: Double,
    val offerPrice: Double,
    val rating: Double,
    val isAvailable: Boolean,
    val image: Int
)