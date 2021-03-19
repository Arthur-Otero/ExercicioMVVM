package com.example.exerciciomvvm.ResultPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exerciciomvvm.ItemRegistered
import com.example.exerciciomvvm.R

class ResultActivity : AppCompatActivity() {
    lateinit var model: ResultViewModel

    val recycle by lazy { findViewById<RecyclerView>(R.id.resultRecycle) }
    val text by lazy { findViewById<TextView>(R.id.priceView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        model = ViewModelProvider(this).get(ResultViewModel::class.java)

        recycle.layoutManager = LinearLayoutManager(this)
        model.item.observe(this){itemRegister->
            recycle.adapter = ResultAdapter(itemRegister)
        }

        model.result.observe(this){
            text.text = "Valor total da compra é $it"
        }
    }
}