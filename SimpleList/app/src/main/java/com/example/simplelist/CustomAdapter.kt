package com.example.simplelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


public class CustomAdapter(private val context: Context,
                           private val itemList: List<ListItem>) : BaseAdapter(){
    override fun getCount(): Int {
        return itemList.size
    }

    override fun getItem(p0: Int): ListItem {
        return itemList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = p1 ?: LayoutInflater.from(context).inflate(R.layout.list_item, p2, false)

        // Get the current item
        val currentItem = getItem(p0)

        val avatarColors = listOf("#5e96fa","#9bcb62","#94a5ac","#ff8866","#f48cd7")

        // Set up the views with the item data
        val name = view.findViewById<TextView>(R.id.textView2)
        val mssv = view.findViewById<TextView>(R.id.textView3)
        val time = view.findViewById<TextView>(R.id.textView2)

        name.text = currentItem.name
        mssv.text=currentItem.mssv
        return view
    }
}