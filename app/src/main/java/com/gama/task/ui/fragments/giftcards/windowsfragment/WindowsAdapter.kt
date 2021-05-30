package com.gama.task.ui.fragments.giftcards.windowsfragment

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

class WindowsAdapter (private val windowsList: List<WindowsData>,private val onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<WindowsAdapter.WindowsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WindowsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_windows_item,
            parent, false)
        return WindowsViewHolder(itemView,onItemClickListener)
    }
    override fun onBindViewHolder(holder: WindowsViewHolder, position: Int) {
        val currentItem = windowsList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2.toString()
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = windowsList.size

    class WindowsViewHolder(itemView: View,onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
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