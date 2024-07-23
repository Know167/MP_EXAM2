package com.example.mp_exam2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var inputApp3=intent.getStringExtra("input")
        Toast.makeText(this,inputApp3, Toast.LENGTH_SHORT).show()

        var spEx: Spinner = findViewById(R.id.spEx)
        var input: EditText = findViewById(R.id.input)

        var rentVal: TextView = findViewById(R.id.rentVal)

        var clothVal: TextView = findViewById(R.id.clothVal)

        var foodVal: TextView = findViewById(R.id.foodVal)



        var submit: Button =findViewById(R.id.submit)
        var opt=arrayOf("Food", "Clothing", "Rent");
        var flag:String="Food"
        spEx.adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,opt)
        spEx.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = opt.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        submit.setOnClickListener { view ->
            when(flag){
                "Food"-> {
                    var food=foodVal.text.toString().toInt()
                    foodVal.text= (food+input.text.toString().toInt()).toString()
                }
                "Clothing"-> {
                    var cloth=clothVal.text.toString().toInt()
                    clothVal.text= (cloth+input.text.toString().toInt()).toString()
                }
                "Rent"-> {
                    var rent=rentVal.text.toString().toInt()
                    rentVal.text= (rent+input.text.toString().toInt()).toString()
            }
            }
        }

    }
}