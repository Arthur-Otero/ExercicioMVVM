package com.example.exerciciomvvm.mainPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exerciciomvvm.Item
import com.example.exerciciomvvm.R

class MainAdapter(val item:List<Item>,val callback: (List<Item>)->Unit):RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_register,parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.nameProduct.text = item[position].description
        holder.priceProduct.text = item[position].value.toString()

        holder.checkbox.setOnCheckedChangeListener{_,checked ->
            item[position].checked = checked
        }
        callback(item)
    }

    override fun getItemCount() = item.size

    inner class MainViewHolder(view: View):RecyclerView.ViewHolder(view){
        val checkbox by lazy { view.findViewById<CheckBox>(R.id.materialCheckBox) }
        val nameProduct by lazy { view.findViewById<TextView>(R.id.name) }
        val priceProduct by lazy { view.findViewById<TextView>(R.id.price) }
    }
}