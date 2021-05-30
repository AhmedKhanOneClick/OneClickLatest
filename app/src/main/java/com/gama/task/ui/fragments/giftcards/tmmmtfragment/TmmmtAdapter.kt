package com.gama.task.ui.fragments.giftcards.tmmmtfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import com.gama.task.ui.fragments.giftcards.itunefragment.ItuneAdapter
import kotlinx.android.synthetic.main.card_careem_item.view.*

class TmmmtAdapter (private val tmmmtList: List<TmmmtData>,private val onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<TmmmtAdapter.TmmmtViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TmmmtViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_tmmmt_item,
            parent, false)
        return TmmmtViewHolder(itemView,onItemClickListener)
    }
    override fun onBindViewHolder(holder: TmmmtViewHolder, position: Int) {
        val currentItem = tmmmtList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2.toString()
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = tmmmtList.size

    class TmmmtViewHolder(itemView: View,onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value1_tv
        val textView2: TextView = itemView.card_value2_tv
        val textView3: TextView = itemView.card_value3_tv
        val textView4: TextView = itemView.card_value4_tv
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