package com.example.simplelist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class ClassList : AppCompatActivity() {
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.classlist)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listt = listOf(
            ListItem("Alice Nguyen", "MSSV001"),
            ListItem("Bob Tran", "MSSV002"),
            ListItem("Charlie Pham", "MSSV003"),
            ListItem("David Le", "MSSV004"),
            ListItem("Emily Vo", "MSSV005"),
            ListItem("Frank Hoang", "MSSV006"),
            ListItem("Grace Bui", "MSSV007"),
            ListItem("Henry Do", "MSSV008"),
            ListItem("Ivy Nguyen", "MSSV009"),
            ListItem("Jacky Dang", "MSSV010")
        )
        var arrayAdapter: ArrayAdapter<ListItem>
        var input = findViewById<TextInputEditText>(R.id.editText1)
        input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // This method is called before the text is changed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (input.toString().length >= 2) {
                    var liss :ArrayList<ListItem> = ArrayList()
                    var i:Int =0
                    while(i<listt.size){
                        if(listt[i].name.contains(input.toString(),ignoreCase = false)||listt[i].mssv.contains(input.toString(),ignoreCase = false)){
                            liss.add(listt[i])
                        }
                        i++
                    }
                    arrayAdapter = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, liss)
                    listNumber.adapter=arrayAdapter

                }
            }

            override fun afterTextChanged(s: Editable?) {
                // This method is called after the text has been changed
            }
        })


    }
}