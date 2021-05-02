package com.gama.task.ui.fragments.gamecards.freefirefragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.card_freefire_item.view.*

class FreefireAdapter (private val freefireList: List<FreefireData>):
    RecyclerView.Adapter<FreefireAdapter.FreefireViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FreefireViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_freefire_item,
            parent, false)
        return FreefireViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: FreefireViewHolder, position: Int) {
        val currentItem = freefireList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = freefireList.size

    class FreefireViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value_1
        val textView2: TextView = itemView.card_value_2
        val textView3: TextView = itemView.card_value_3
        val textView4: TextView = itemView.card_value_4
    }

}