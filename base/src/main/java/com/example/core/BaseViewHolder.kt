package com.example.core

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder: RecyclerView.ViewHolder{

    constructor(itemView: View):super(itemView)
    private val viewHashMap = HashMap<Int, View>()

    @SuppressWarnings("unchecked")
    fun  <T: View> getView(id: Int): T{
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id);
            viewHashMap[id] = view;
        }
        return view as T;
    }

    fun setText(id: Int, text: String? ) {
        ((getView(id)) as TextView).text = text;
    }
}