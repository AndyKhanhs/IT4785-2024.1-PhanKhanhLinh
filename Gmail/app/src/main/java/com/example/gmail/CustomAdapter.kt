package com.example.gmail;

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
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
        val senderName = view.findViewById<TextView>(R.id.textView)
        val content = view.findViewById<TextView>(R.id.textView3)
        val time = view.findViewById<TextView>(R.id.textView2)
        val isLike = view.findViewById<ImageView>(R.id.imageView3)
        val avatar = view.findViewById<CustomAvatar>(R.id.textView4)

        isLike.setOnClickListener {
            if (currentItem.isLike) {
                currentItem.isLike=false
                isLike.setImageResource(
                    content.resources.getIdentifier(
                        "star",
                        "drawable",
                        context.packageName
                    )
                )
            } else {
                currentItem.isLike=true
                isLike.setImageResource(
                    content.resources.getIdentifier(
                        "star_full",
                        "drawable",
                        context.packageName
                    )
                )
            }
        }


        senderName.text = currentItem.senderName
        content.text=currentItem.content
        time.text=currentItem.time
        avatar.setText(currentItem.senderName.substring(0,1),avatarColors.random())
        return view
    }
}
