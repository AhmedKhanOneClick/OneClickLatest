package com.gama.task.ui.fragments.giftcards.ebayfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import kotlinx.android.synthetic.main.card_ebay_item.view.*

class EbayAdapter (private val ebayList: List<EbayData>):
    RecyclerView.Adapter<EbayAdapter.EbayViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EbayViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_ebay_item,
            parent, false)
        return EbayViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: EbayViewHolder, position: Int) {
        val currentItem = ebayList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = ebayList.size

    class EbayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value1_tv
        val textView2: TextView = itemView.card_value2_tv
        val textView3: TextView = itemView.card_value3_tv
        val textView4: TextView = itemView.card_value4_tv
    }

}