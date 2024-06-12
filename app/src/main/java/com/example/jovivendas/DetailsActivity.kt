package com.example.jovivendas

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.jovivendas.model.Product

class DetailsActivity : AppCompatActivity() {

    lateinit var img : ImageView
    lateinit var imgTwo : ImageView
    lateinit var txtTitle : TextView
    lateinit var txtprice : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        img = findViewById(R.id.img_character)
        imgTwo = findViewById(R.id.img_character_two)
        txtTitle = findViewById(R.id.title_item)
        txtprice = findViewById(R.id.txt_price_item)

        val product: Product? = intent.getSerializableExtra("Product") as Product?
        product.let {
            txtTitle.text = it?.title
            txtprice.text = it?.price
            val resourceId = baseContext.resources.getIdentifier(product?.image, "drawable", baseContext.packageName)
            img.setImageResource(resourceId)
            imgTwo.setImageResource(resourceId)
        }

    }
}