package com.example.exerciciomvvm.mainPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exerciciomvvm.Item
import com.example.exerciciomvvm.ItemRegistered
import com.example.exerciciomvvm.R
import com.example.exerciciomvvm.ResultPage.ResultActivity
import com.example.exerciciomvvm.itemRegisterPage.ItemRegister
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    val recycle by lazy { findViewById<RecyclerView>(R.id.itensRecycle) }
    val resgiter by lazy { findViewById<FloatingActionButton>(R.id.addition) }
    val result by lazy { findViewById<FloatingActionButton>(R.id.results) }

    lateinit var model:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ViewModelProvider(this).get(MainViewModel::class.java)

        recycle.layoutManager = LinearLayoutManager(this)

        model.item.observe(this){
            recycle.adapter = MainAdapter(it){ checkedList->
                resultNavigation(checkedList)
            }
        }

        resgiter.setOnClickListener{
            val intent = Intent(this, ItemRegister::class.java)
            startActivity(intent)
        }

    }

    private fun resultNavigation(checkedList: List<Item>) {
        result.setOnClickListener {
            model.isChecked(checkedList)
            model.itemChecked.observe(this){
                val register = ItemRegistered
                register.checkedItems = it
            }
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }
    }
}