package com.gama.task.ui.fragments.gamecards.legendsfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R

import kotlinx.android.synthetic.main.card_legends_item.view.*

class LegendsAdapter (private val legendsList: List<LegendsData>):
    RecyclerView.Adapter<LegendsAdapter.LegendsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegendsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_legends_item,
            parent, false)
        return LegendsViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: LegendsViewHolder, position: Int) {
        val currentItem = legendsList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = legendsList.size

    class LegendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value_1
        val textView2: TextView = itemView.card_value_2
        val textView3: TextView = itemView.card_value_3
        val textView4: TextView = itemView.card_value_4
    }

}