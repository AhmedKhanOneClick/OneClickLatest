package com.gama.task.ui.fragments.giftcards.amazonfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.cinemacards.kitaabsawti.KitaabsawtiAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import kotlinx.android.synthetic.main.card_amazon_item.view.*
import kotlinx.android.synthetic.main.card_amazon_item.view.card_value1_tv
import kotlinx.android.synthetic.main.card_amazon_item.view.card_value2_tv
import kotlinx.android.synthetic.main.card_amazon_item.view.card_value3_tv
import kotlinx.android.synthetic.main.card_amazon_item.view.card_value4_tv
import kotlinx.android.synthetic.main.card_kitaabsawti_item.view.*

class AmazonAdapter(private val amazonList: List<AmazonData>,private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<AmazonAdapter.AmazonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmazonViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_amazon_item,
            parent, false)
        return AmazonViewHolder(itemView,onItemClickListener)
    }
    override fun onBindViewHolder(holder: AmazonViewHolder, position: Int) {
        val currentItem = amazonList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2.toString()
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = amazonList.size

    class AmazonViewHolder(itemView: View,onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
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