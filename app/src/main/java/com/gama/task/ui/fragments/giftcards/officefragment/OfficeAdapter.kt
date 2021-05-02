package com.gama.task.ui.fragments.giftcards.officefragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import kotlinx.android.synthetic.main.card_noon_item.view.*

class OfficeAdapter (private val officeList: List<OfficeData>):
    RecyclerView.Adapter<OfficeAdapter.OfficeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_office_item,
            parent, false)
        return OfficeViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: OfficeViewHolder, position: Int) {
        val currentItem = officeList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = officeList.size

    class OfficeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value1_tv
        val textView2: TextView = itemView.card_value2_tv
        val textView3: TextView = itemView.card_value3_tv
        val textView4: TextView = itemView.card_value4_tv
    }

}