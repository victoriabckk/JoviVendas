package com.example.jovivendas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    lateinit var img : ImageView
    lateinit var imgTwo : ImageView
    lateinit var txtTitle : TextView
    lateinit var txtDesc : TextView
    lateinit var txtprice : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        img = findViewById(R.id.img_character)
        imgTwo = findViewById(R.id.img_character_two)
        txtTitle = findViewById(R.id.title_item)
        txtDesc = findViewById(R.id.description_item)
        txtprice = findViewById(R.id.text_price)

        val item = intent.getStringExtra(Intent.EXTRA_TEXT)



    }
}