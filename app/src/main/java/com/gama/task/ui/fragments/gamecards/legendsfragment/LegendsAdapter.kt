package com.gama.task.ui.fragments.gamecards.legendsfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.gamecards.jalsaatfragment.JalsaatAdapter

import kotlinx.android.synthetic.main.card_legends_item.view.*

class LegendsAdapter (private val legendsList: List<LegendsData>,private val onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<LegendsAdapter.LegendsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegendsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_legends_item,
            parent, false)
        return LegendsViewHolder(itemView,onItemClickListener)
    }
    override fun onBindViewHolder(holder: LegendsViewHolder, position: Int) {
        val currentItem = legendsList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2.toString()
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = legendsList.size

    class LegendsViewHolder(itemView: View,onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value_1
        val textView2: TextView = itemView.card_value_2
        val textView3: TextView = itemView.card_value_3
        val textView4: TextView = itemView.card_value_4
        init {
            itemView.setOnClickListener {
                onItemClickListener.onClick(absoluteAdapterPosition)
            }
            itemView.setOnLongClickListener {
                onItemClickListener.onLongClick(adapterPosition)

                return@setOnLongClickListener true
            }

        }
    }
    interface OnItemClickListener{
        fun onClick(position: Int)
        fun onLongClick(position: Int)
    }


}