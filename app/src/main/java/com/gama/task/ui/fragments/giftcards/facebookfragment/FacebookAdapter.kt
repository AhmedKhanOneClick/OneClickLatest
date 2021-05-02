package com.gama.task.ui.fragments.giftcards.facebookfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.giftcards.ebayfragment.EbayAdapter
import com.gama.task.ui.fragments.giftcards.ebayfragment.EbayData
import kotlinx.android.synthetic.main.card_ebay_item.view.*

class FacebookAdapter(private val facebookList: List<FacebookData>):
    RecyclerView.Adapter<FacebookAdapter.FacebookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacebookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_facebook_item,
            parent, false)
        return FacebookViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: FacebookViewHolder, position: Int) {
        val currentItem = facebookList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = facebookList.size

    class FacebookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value1_tv
        val textView2: TextView = itemView.card_value2_tv
        val textView3: TextView = itemView.card_value3_tv
        val textView4: TextView = itemView.card_value4_tv
    }

}