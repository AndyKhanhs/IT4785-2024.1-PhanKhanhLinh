package com.example.simplelist

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var listNumber: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var input = findViewById<EditText>(R.id.editText)
        val options = findViewById<RadioGroup>(R.id.radioGroup)
        val evenOption = findViewById<RadioButton>(R.id.radioButton)
        val oddOption = findViewById<RadioButton>(R.id.radioButton2)
        val squareOption = findViewById<RadioButton>(R.id.radioButton3)
        val showButton = findViewById<Button>(R.id.button)
        listNumber = findViewById<ListView>(R.id.listView)
        val error= findViewById<TextView>(R.id.textView)


        showButton.setOnClickListener{
            val radioId = options.checkedRadioButtonId
            if(input.text.toString().isEmpty()){
                error.text="Vui lòng nhập số "
                error.visibility= View.VISIBLE
                return@setOnClickListener
            }
            val number =input.text.toString().toIntOrNull()
            if(number==null ||number<=0){
                error.text="Vui lòng nhập số nguyên dương lớn hơn 0"
                error.visibility= View.VISIBLE
                return@setOnClickListener
            }

            if(evenOption.id==radioId){
                var i:Int = 0
                val list: ArrayList<Int> = ArrayList()
                while(i<number){
                    if(i%2==0){
                        list.add(i)
                    }
                    i+=1
                }
                arrayAdapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, list)
                listNumber.adapter=arrayAdapter
            } else if(oddOption.id==radioId){
                var i:Int = 0
                val list: ArrayList<Int> = ArrayList()
                while(i<number){
                    if(i%2!=0){
                        list.add(i)
                    }
                    i+=1
                }
                arrayAdapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, list)
                listNumber.adapter=arrayAdapter
            } else if(squareOption.id==radioId) {
                var i:Int = 0
                val list: ArrayList<Int> = ArrayList()
                while(i<number){
                    if(i*i<=number){
                        list.add(i*i)
                    }
                    i+=1
                }
                arrayAdapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, list)
                listNumber.adapter=arrayAdapter
            }
        }
    }
}