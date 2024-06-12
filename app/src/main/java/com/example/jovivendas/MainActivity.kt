package com.example.jovivendas

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jovivendas.Adapter.ProductAdapter
import com.example.jovivendas.services.DataService

class MainActivity : AppCompatActivity() {

    lateinit var adapter : ProductAdapter
    lateinit var recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.product_recyclerView)

        adapter = ProductAdapter(this, DataService.productList)

        var spanCount  = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val layotManager = GridLayoutManager(this, spanCount)
        recycler.layoutManager = layotManager
        recycler.adapter = adapter
    }
}