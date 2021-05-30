package com.gama.task.ui.fragments.gamecards.lordsfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.gamecards.legendsfragment.LegendsAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.card_lords_item.view.*

class LordsAdapter (private val lordsList: List<LordsData>,private val onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<LordsAdapter.LordsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LordsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_lords_item,
            parent, false)
        return LordsViewHolder(itemView,onItemClickListener)
    }
    override fun onBindViewHolder(holder: LordsViewHolder, position: Int) {
        val currentItem = lordsList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2.toString()
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = lordsList.size

    class LordsViewHolder(itemView: View,onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
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