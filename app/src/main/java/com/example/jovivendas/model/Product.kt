package com.example.jovivendas.model

import java.io.Serializable

data class Product(val title: String, val price: String, val image: String, val description: String) : Serializable
