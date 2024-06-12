package com.example.jovivendas.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jovivendas.DetailsActivity
import com.example.jovivendas.R
import com.example.jovivendas.model.Product


class ProductAdapter(val context: Context, val product: List<Product>) : RecyclerView.Adapter<ProductAdapter.HolderProduct>() {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, positon: Int): HolderProduct {
     val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return HolderProduct(view)

    }

    override fun getItemCount(): Int {
       return product.count()
    }

    override fun onBindViewHolder(holder: HolderProduct, positon: Int) {
        holder.bindProduct(product[positon], context)

        holder.productImage?.setOnClickListener {
            val detailsActivity: Intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("Product", product[positon])
            }
            context.startActivity(detailsActivity)
        }
    }

    inner class HolderProduct(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val productImage = itemView?.findViewById<ImageView>(R.id.product_img)
        val productName = itemView?.findViewById<TextView>(R.id.name_product)
        val productPrice = itemView?.findViewById<TextView>(R.id.text_price)

        fun bindProduct(product: Product, context: Context) {
            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            productImage?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price
        }
    }
}