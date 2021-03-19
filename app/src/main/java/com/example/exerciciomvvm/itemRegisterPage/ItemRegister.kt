package com.example.exerciciomvvm.itemRegisterPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.exerciciomvvm.Item
import com.example.exerciciomvvm.ItemRegistered
import com.example.exerciciomvvm.R
import com.example.exerciciomvvm.mainPage.MainActivity

class ItemRegister : AppCompatActivity() {
    lateinit var model:RegisterViewModel

    val productName by lazy { findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.productName)}
    val productValue by lazy { findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.value)}
    val button by lazy { findViewById<Button>(R.id.registerButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_register)

        model = ViewModelProvider(this).get(RegisterViewModel::class.java)

        button.setOnClickListener{
            login()
        }
        configureFields()
    }

    private fun configureFields() {
        model.nameValidate.observe(this){
            if (it)
                productName.error = null
            else
                productName.error = "Campo Obrigatorio"

            navigate()
        }

        model.valueValidate.observe(this){
            if (it)
                productValue.error = null
            else
                productValue.error = "Campo Obrigatorio"

            navigate()
        }
    }

    private fun navigate() {
        if (model.nameValidate.value == true && model.valueValidate.value==true){
            val itemRegister = ItemRegistered
            itemRegister.items.add(Item(productName.text.toString(),productValue.text.toString().toDouble()))
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


    private fun login() {
        val nameField = productName.text.toString()
        val valueField = productValue.text.toString()

        model.validateFields(nameField,valueField)
    }
}