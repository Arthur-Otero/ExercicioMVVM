package com.example.exerciciomvvm.ResultPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exerciciomvvm.Item
import com.example.exerciciomvvm.R
import com.example.exerciciomvvm.mainPage.MainAdapter

class ResultAdapter(val item:List<Item>):
    RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_register, parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.nameProduct.text = item[position].description
        holder.priceProduct.text = item[position].value.toString()
    }

    override fun getItemCount() = item.size

    inner class ResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val checkbox by lazy { view.findViewById<CheckBox>(R.id.materialCheckBox) }
        val nameProduct by lazy { view.findViewById<TextView>(R.id.name) }
        val priceProduct by lazy { view.findViewById<TextView>(R.id.price) }
    }
}